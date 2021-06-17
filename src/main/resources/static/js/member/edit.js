var edit = {
    init : function () {
        var _this = this;

        $('#btn-edit').on('click', function () {
            _this.edit();
        });

        $('#add-skill').on('click', function () {
            _this.addSkill();
        });
    },
    edit : function () {
        var data = {
            name: $('#name-id').val(),
            nearestStation: $('#nearestStation-id').val(),
            phone: $('#phone-id').val(),
            skills: [],
        };

        // スキルをセット
        let length = $( "input[name^='skills']" ).length;
        for (let i = 0; i < length/2; i++) {
            let skill = {
                name: $( "input[name^='skills-" + i +"-name']" ).val(),
                percent: $( "input[name^='skills-" + i +"-percent']" ).val(),
            };
            data.skills.push(skill);
        }

        // idを取得
        const pathNames = location.pathname.split('/');
        const id = pathNames[pathNames.length - 1];

        // 正常更新時にModalセット
        api.edit('/api/v1/m/' + id, data, () => {
            $(".close").on('click', () => window.location.href = '/m/search');
            $(".btn-success").on('click', () => window.location.href = '/m/search');
            $('#success-modal-title').text('メンバー更新');
            $('#success-modal-body').text('メンバーが正常に更新されました。');
            $("#success").modal('show');
        });
    },
    addSkill : function () {
        let length = $( "input[name^='skills']" ).length;
        let targetIdx = length / 2;
        $("#skill-body").append(`
                            <div class='row'>
                                <div class='col-12'>
                                    <fieldset>
                                        <div class='input-group'>
                                            <div class='input-group-prepend'>
                                                <span class='input-group-text'>スキル名</span>
                                            </div>
                                            <input type='text' aria-label='Skill name' class='form-control'
                                                   name='skills-${targetIdx}-name' id='skills-${targetIdx}-name-id'>
                                            <input type='number' aria-label='Skill percent' class='form-control'
                                                   name='skills-${targetIdx}-percent' id='skills-${targetIdx}-percent-id'>
                                            <div class='input-group-prepend'>
                                                <span class='input-group-text'>パーセント(%)</span>
                                            </div>

                                        </div>
                                    </fieldset>
                                    <div id='skills-${targetIdx}-name-validation' class='invalid-feedback'>
                                        <i class='bx bx-radio-circle'></i>
                                    </div>
                                    <div id='skills-${targetIdx}-percent-validation' class='invalid-feedback'>
                                        <i class='bx bx-radio-circle'></i>
                                    </div>
                                </div>

                            </div>
        `);
    }
};

edit.init();