let good = {
    delCheckedItem: function () {

        let test = [];

        $('input:checkbox[name=good]').each(function () {
            if ($(this).is(":checked")) {
                test.push($(this).val());
                console.log(test);
            }
        });

        // 선택된 항목을 삭제하는 메서드 호출
        this.checkItem();

        $.ajax({
            url: '/deleteGoodList', //Controller에서 요청 받을 주소
            type: 'POST', //POST 방식으로 전달
            data: {"g_pk": test},
            success: function (result) {
                if (result > 0) {
                    // 선택된 항목 삭제 후 페이지 새로고침
                    location.reload();
                } else {
                    alert("오류발생");
                }
            }
        });
    },

    checkItem: function () {

    }
}

// function deleteGoodList 를 하기위해서 필요한
// parameter가 뭔가요? : good pk를 딜리트하면 -> good table에서 삭제됨
// 화면에 나타나있는 goodList에서 good Pk를 가져오는법 ?
// 체크박스에서 gook pk를 가져왔는데 한개를 가져올 수 도 있고 , && 2개 , 3, 4 , 5 개를 가져와서 5개를 지울수도 있슴 그러면?
// 1. javascript 배열을 만든다
// 2. 배열에 gook PK값을 넣는다.
// 3. /deleteGoodList의 컨트롤러에 data : goodPk의 배열을 넣는다
// 4. 컨트롤러에서 배열을 받는다.
// 5. 컨트롤러에서 받은 배열을 service로 넘긴다.
// 6. service만들고 , serviceImpl을 에 for문을 만든다.
// 7. for문안에 dto에 gookPk를 넣고 mapper를 호출한다.
