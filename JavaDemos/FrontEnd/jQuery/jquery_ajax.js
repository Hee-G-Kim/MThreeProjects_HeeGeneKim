//Button#id


$(document).ready(function () {
    $("button#getcontacts").click(function () {
        $.ajax({
            type: 'GET',
            url: 'http://contactlist.us-east-1.elasticbeanstalk.com/contacts',
            //your getstudentregistratonApp url
            
            success: function (contactArray) {
                var contactsDiv = $('div#allContacts');
                //$("div#allContacts").html(result);
                //alert("result:" + contactArray);

                $.each(contactArray, function (index, contact) {
                    var contactInfo = '<p>';
                    contactInfo += 'Name: ' + contact.firstName + ' ' +
                        contact.lastName + '<br>';
                    contactInfo += 'Company: ' + contact.company + '<br>';
                    contactInfo += 'Email: ' + contact.email + '<br>';
                    contactInfo += 'Phone: ' + contact.phone + '<br>';
                    contactInfo += '</p><hr>';
                
                    contactsDiv.append(contactInfo);
                })
            },
            error: function () {


                alert('FAILURE!');
            }
        })
    });

})