var api = {
    init : function () {
    },
    save : function (url, data, callback) {

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
            // TODO: validation
        });
    }
};

api.init();