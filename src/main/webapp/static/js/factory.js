/**
 * Created by mixmax on 20.03.16.
 */
var myApp = angular.module('myApp');

myApp.factory('Contact', ['$resource', function ($resource) {
    //$resource() function returns an object of resource class
    return $resource('http://localhost:8081/contact/:id',
        {id: '@id'},
        {
            update: {
                method: 'PUT' // To send the HTTP Put request when calling this custom update method.
            }

        },
        {
            stripTrailingSlashes: false
        }
    );
}]);

