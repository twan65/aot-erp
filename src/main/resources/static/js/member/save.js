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

        $.ajax({
            type: 'POST',
            url: '/api/v1/m',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(data) {
            alert('アイデアが登録されました。');
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

save.init();