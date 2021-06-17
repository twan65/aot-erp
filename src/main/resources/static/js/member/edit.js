var edit = {
    init : function () {
        var _this = this;

        $('#btn-edit').on('click', function () {
            _this.edit();
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
                name: $( "input[name^='skills[" + i +"].name']" ).val(),
                percent: $( "input[name^='skills[" + i +"].percent']" ).val(),
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
    }
};

edit.init();