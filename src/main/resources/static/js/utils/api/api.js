var api = {
    init : function () {
    },
    save : function (url, data, callback) {
        validation.clearValidationField();

        $.ajax({
            type: 'POST',
            url: url,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(data) {
            if (callback) {
                callback();
            }
        }).fail(function(error) {
            if (!error) {
                return;
            }

            if (error.status == "400" && error.responseJSON && error.responseJSON.errors) {
                validation.setErrors(error.responseJSON.errors);
                validation.setValidationField(error.responseJSON.errors)
                return;
            }
        });
    },
    search : function (url, data, callback) {
        $.ajax({
            type: 'POST',
            url: url,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(data) {
            if (callback) {
                callback(data);
            }
        }).fail(function(error) {
            if (!error) {
                return;
            }
        });
    },
    edit : function (url, data, callback) {
        validation.clearValidationField();

        $.ajax({
            type: 'PUT',
            url: url,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(data) {
            if (callback) {
                callback();
            }
        }).fail(function(error) {
            if (!error) {
                return;
            }

            if (error.status == "400" && error.responseJSON && error.responseJSON.errors) {
                validation.setErrors(error.responseJSON.errors);
                validation.setValidationField(error.responseJSON.errors)
                return;
            }
        });
    }
};

api.init();