var search = {
    init : function () {
        var _this = this;

        $('#btn-search').on('click', function () {
            $('.card-header').hide()
            _this.search('/api/v1/m/search');
        });
    },
    search : function (url) {
        var data = {
            name: $('#name-id').val(),
            employmentType: $('#employmentType-id').val(),
            department: $('#department-id').val(),
            enteredDateFrom: $('#enteredDateFrom-id').val(),
            enteredDateTo: $('#enteredDateTo-id').val(),
            ageFrom: $('#ageFrom-id').val(),
            ageTo: $('#ageTo-id').val(),
        };

        api.search(url, data, search.showSearchResult);
    },
    showSearchResult : function (res) {

        $("#result-body").empty();
        $("#search-result").hide();

        if(!res || !res.content || !res.content.length) {
            $(".close").on('click', () => $("#danger").modal('hide'));
            $(".btn-danger").on('click', () => $("#danger").modal('hide'));
            $('#danger-modal-title').text('メンバー一覧');
            $('#danger-modal-body').text('検索結果がありません。')　// TODO: メッセージは設定ファイルから持ってくることを検討
            $("#danger").modal('show');
            return;
        }

        const { content } = res;
        content.map(memberInfo => {
            $("#result-body").append(`
                <tr>
                    <td>${memberInfo.email}</td>
                    <td><a href=/m/${memberInfo.id}>${memberInfo.name}</a></td>
                    <td>${memberInfo.department}</td>
                    <td>${memberInfo.position}</td>
                    <td>${memberInfo.nationality}</td>
                    <td>${memberInfo.enteredDate}</td>
                    <td>${memberInfo.employmentType}</td>
                </tr>
            `);
        });

        $("#search-result").show();
        pagination.showPagination(res.first, res.last, res.pageable.pageNumber);
        pagination.setEvent((page) => search.search('/api/v1/m/search?page=' + page));
//        pagination.showPagination(res.first, res.last, res.totalElements, res.pageable.pageNumber, res.totalPages);
    }
};

search.init();