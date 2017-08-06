var pictureNumber = 1;
var featureNumber = 1;

function addPictureURLTextField() {
    pictureNumber += 1;

    // $('#picture_added').remove();
    // $('#picture_deleted').remove();
    $('.add_delete_picture_buttons').remove();
    $('.prev_picture').removeClass('prev_picture');
    $('.last_picture').addClass('prev_picture');
    $('.last_picture').removeClass('last_picture');


    $("<tr class='last_picture'>\n" +
        "                <td>Картинка " + pictureNumber + ": </td>\n" +
        "                <td><input name=\"pictureUrl" + pictureNumber + "\" type=\"text\"></td>\n" +
        "                <td class=\"add_delete_picture_buttons\"><span><input class=\"button manage-mod-green mod-small-min-width\" type=\"button\" id=\"picture_added\" value=\"+\" onclick=\"addPictureURLTextField()\"></span></td>\n" +
        "            </tr>").insertBefore("#last_row");
}

function addFeatureTextField() {
    featureNumber += 1;

    // $('#feature_added').remove();
    // $('#feature_deleted').remove();
    $('.add_delete_feature_buttons').remove();

    $('.prev_feature').removeClass('prev_feature');
    $('.last_feature').addClass('prev_feature');
    $('.last_feature').removeClass('last_feature');

    $("<tr class='last_feature'>\n" +
        "                <td>Особенность " + featureNumber + ": </td>\n" +
        "                <td><input name=\"feature" + featureNumber + "\" type=\"text\"></td>\n" +
        "                <td class = \"add_delete_feature_buttons\"><span><input class=\"button manage-mod-green mod-small-min-width\" type=\"button\" value=\"+\" id=\"feature_added\" onclick=\"addFeatureTextField()\"></span></td>\n" +
        "            </tr>").insertBefore("#picture_1");
}

// function deletePictureURLTextField() {
//     pictureNumber -= 1;
//
//     $('.last_picture').remove();
//     $('.prev_picture').append(' <td class="add_delete_picture_buttons"><span><input type="button" id="picture_added" value="Добавить картинку" onclick="addPictureURLTextField()"><input type="button" id="picture_deleted" value="Удалить картинку" onclick="deletePictureURLTextField()"></span></td>');
//
//
// }
//
// function deleteFeatureTextField() {
//     featureNumber -= 1;
//
//     $('.last_feature').remove();
//
//     $('.prev_feature').append('<td class = "add_delete_feature_buttons"><span><input type="button" value="Добавить особенность" id="feature_added" onclick="addFeatureTextField()"><input type="button" id="feature_deleted" value="Удалить особенность" onclick="deleteFeatureTextField()"></span></td>');
// }