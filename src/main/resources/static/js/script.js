/**
 * Created by admin on 01.03.2018.
 */
idAnswer = 1;
var voting = {
    subjectText: "",
    answerChoice: {}
};
$(document).ready(function () {

    $("#addAnswerText").click(function () {
        addAnswerText();
    });
    $("#saveSubjectText").click(function () {
        console.log(saveSubjectTextInJson());
        $.post( "addVoting",{voting :saveSubjectTextInJson()} , function( data ) {
           console.log(data );
        });

    })

});
function saveSubjectTextInJson() {
    voting.subjectText = $("#subjectText").val()
    $('input').each(function (i, elem) {
        voting.answerChoice[$(elem).attr("aria-describedby")] = $(elem).val();

    });
    return (JSON.stringify(voting));
}

function addAnswerText() {
    var elementClassic = '<div class="input-group"><div class="input-group-prepend"><span class="input-group-text" id=" answerText' + idAnswer + '"> Ответ ' +
        idAnswer + '</span></div>' +
        '<input type="text" class="form-control" placeholder="Текст ответа" aria-label="Текст ответа"  aria-describedby=" answerText' + idAnswer + '" /></div>';
    $('#answerChoice').append(elementClassic);
    idAnswer = idAnswer + 1;
}