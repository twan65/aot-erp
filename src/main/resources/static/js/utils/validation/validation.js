var validation = {
    init : function () {
    },
    errors: null,
    setErrors : function(errors) {
        validation.errors = errors;
    },
    setValidationField: function (errors) {
        for (const err of errors) {
            var errInfo = err.split(':');
            var errField = errInfo[0].replaceAll('.', '').replace(/\[|\]/g, '-');
            var errMessage = errInfo[1];
            var targetField = $('#'+ errField + '-id');
            targetField.addClass('is-invalid');
            $('#' + errField + '-validation').text(errMessage);
        }
    },
    clearValidationField : function () {
        if (!validation.errors) return ;

        for (const err of validation.errors) {
            var errInfo = err.split(':');
            var errField = errInfo[0].replaceAll('.', '').replace(/\[|\]/g, '-');
            var errMessage = errInfo[1];
            var targetField = $('#'+ errField + '-id');
            targetField.removeClass('is-invalid');
            $('#' + errField + '-validation').text('');
        }
        validation.errors = null;
    }
};

validation.init();