var pagination = {
    init : function () {},
    index: 0,
    showPagination : function (first, last, pageNumber) {
        if (first) {
            $("#page-back").hide();
        } else {
            $("#page-back").show();
        }

        if (last) {
            $("#page-next").hide();
        } else {
            $("#page-next").show();
        }

        pagination.index = pageNumber;
        $("#page-number").text(pageNumber + 1);
    },
    setEvent : function(callback) {
        $("#page-back").on('click', function() {
            if(callback) callback(pagination.index - 1);
        });
        $("#page-next").on('click', function() {
            if(callback) callback(pagination.index + 1);
        });
    }
}

pagination.init();