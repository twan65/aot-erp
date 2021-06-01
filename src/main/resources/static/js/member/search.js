var search = {
    init : function () {
        var _this = this;

        $('#btn-search').on('click', function () {
            _this.search();
        });
    },
    search : function () {
        var data = {
            name: $('#name-id').val(),
            employmentType: $('#employmentType-id').val(),
            department: $('#department-id').val(),
            enteredDateFrom: $('#enteredDateFrom-id').val(),
            enteredDateTo: $('#enteredDateTo-id').val(),
            ageFrom: $('#ageFrom-id').val(),
            ageTo: $('#ageTo-id').val(),
        };

        // TODO: page処理どうするのか
        api.search('/api/v1/m/search', data, search.showSearchResult);
    },
    showSearchResult : function (res) {
        if(!res || !res.content || !res.content.length) {
            // TODO: 検索結果がありません。
        }

        const { content } = res;
        // TODO: データのコード変換
        content.map(memberInfo => {
            $("#result-body").append(`
                <tr>
                    <td>${memberInfo.email}</td>
                    <td>${memberInfo.name}</td>
                    <td>${memberInfo.department}</td>
                    <td>${memberInfo.position}</td>
                    <td>${memberInfo.nationality}</td>
                    <td>${memberInfo.enteredDate}</td>
                    <td>${memberInfo.employmentType}</td>
                </tr>
            `);
        });

        $("#search-result").show();
    }
};

search.init();