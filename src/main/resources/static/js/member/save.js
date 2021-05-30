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
            age: $('#age-id').val(),
            sex: $('#sex-id').val(),
            nationality: $('#nationality-id').val(),
        };

        api.save('/api/v1/m', data, () => alert('メンバー登録が正常にできました。'));
    }
};

save.init();