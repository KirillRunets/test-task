function createRadioElement(elem) {
    var value = document.getElementById('answer').value;
    var input = document.createElement('input');

    input.type = 'radio';
    input.value = value;

    elem.parentNode.insertBefore(input, elem.nextSibling);
}

function createAnswer() {
    var text = document.getElementById("answer").value;
    document.getElementById("answer").value = "";

    if(!text){
        return;
    }

    var li = document.createElement('li');
    li.innerHTML = text;

    document.getElementById('ul-id').appendChild(li);
}