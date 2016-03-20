<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>AngularJS $http Example</title>
    <style>
        .firstName.ng-valid {
            background-color: lightgreen;
        }

        .firstName.ng-dirty.ng-invalid-required {
            background-color: red;
        }

        .firstName.ng-dirty.ng-invalid-minlength {
            background-color: yellow;
        }

        .tel.ng-valid {
            background-color: lightgreen;
        }

        .tel.ng-dirty.ng-invalid-required {
            background-color: red;
        }

        .tel.ng-dirty.ng-invalid-email {
            background-color: yellow;
        }

    </style>

</head>
<body ng-app="myApp" class="ng-cloak">
<div class="generic-container" ng-controller="ContactController as ctrl">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Contact Registration Form </span></div>
        <div class="formcontainer">
            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="ctrl.contact.tel"/>
                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="firstName">Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.contact.firstName" id="firstName"
                                   class="firstName form-control input-sm" placeholder="Enter your name" required
                                   ng-minlength="3"/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.firstName.$error.required">This is a required field</span>
                                <span ng-show="myForm.firstName.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="myForm.firstName.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="lastName">Lastname</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.contact.lastName" id="lastName"
                                   class="form-control input-sm"
                                   placeholder="Enter your lastName" required ng-minlength="3"/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.lastName.$error.required">This is a required field</span>
                                <span ng-show="myForm.lastName.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="myForm.lastName.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="tel">Phone</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="ctrl.contact.tel" id="tel" class="tel form-control input-sm"
                                   placeholder="Enter your tel" required ng-minlength="5"/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.tel.$error.required">This is a required field</span>
                                <span ng-show="myForm.tel.$error.minlength">Minimum length required is 5</span>
                                <span ng-show="myForm.tel.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit" value="{{!ctrl.contact.id ? 'Add' : 'Update'}}"
                               class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm"
                                ng-disabled="myForm.$pristine">Reset Form
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="panel panel-default">

        <div class="panel-heading"><span class="lead">List of Contacts </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>

                    <th>Name</th>
                    <th>Last Name</th>
                    <th>Tel</th>
                    <th>ID</th>
                    <th width="20%"></th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="c in ctrl.contacts">
                    <!--   <td><span ng-bind="u.id"></span></td> -->
                    <td><span ng-bind="c.firstName"></span></td>
                    <td><span ng-bind="c.lastName"></span></td>
                    <td><span ng-bind="c.tel"></span></td>
                    <td><span ng-bind="c.id"></span></td>
                    <td>
                        <button type="button" ng-click="ctrl.edit(c.id)" class="btn btn-success custom-width">Edit
                        </button>
                        <button type="button" ng-click="ctrl.remove(c.id)" class="btn btn-danger custom-width">Remove
                        </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>
<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
<script type="text/javascript" src="/static/js/vendor/jquery-1.11.1.js"></script>
<script type="text/javascript" src="/static/js/vendor/angular.min.js"></script>
<script type="text/javascript" src="/static/js/vendor/angular-resource.js"></script>
<script type="text/javascript" src="/static/js/vendor/bootstrap.min.js"></script>
<script src="<c:url value='/static/js/app.js' />"></script>
<script src="<c:url value='/static/js/factory.js' />"></script>
<script src="<c:url value='/static/js/contact_controller.js' />"></script>


</body>
</html>