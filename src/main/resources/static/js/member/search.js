var search = {
    init : function () {
        var _this = this;

        $('#btn-search').on('click', function () {
            _this.search();
        });
    },
    search : function () {
//        var data = {
//            name: $('#name-id').val(),
//            employmentType: $('#employmentType-id').val(),
//            department: $('#department-id').val(),
//            enteredDateFrom: $('#enteredDateFrom-id').val(),
//            enteredDateTo: $('#enteredDateTo-id').val(),
//            ageFrom: $('#ageFrom-id').val(),
//            ageTo: $('#ageTo-id').val(),
//        };
//
//        api.save('/api/v1/m/search', data, null);
    }
};

search.init();