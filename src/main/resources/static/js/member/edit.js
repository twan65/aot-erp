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
        };

        // TODO: スキルセット

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