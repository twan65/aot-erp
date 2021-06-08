var save = {
    init : function () {
        var _this = this;

        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            email: $('#email-id').val(),
            name: $('#name-id').val(),
            employmentType: $('#employmentType-id').val(),
            enteredDate: $('#enteredDate-id').val(),
            department: $('#department-id').val(),
            position: $('#position-id').val(),
            dateOfBirth: $('#dateOfBirth-id').val(),
            sex: $('#sex-id').val(),
            nationality: $('#nationality-id').val(),
        };

        // 正常登録時にModalセット
        api.save('/api/v1/m', data, () => {
            $(".close").on('click', () => window.location.href = '/m/search');
            $(".btn-success").on('click', () => window.location.href = '/m/search');
            $('#success-modal-title').text('メンバー登録');
            $('#success-modal-body').text('メンバーが正常に登録されました。');
            $("#success").modal('show');
        });
    }
};

save.init();