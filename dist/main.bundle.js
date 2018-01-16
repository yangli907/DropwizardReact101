/******/ (function(modules) { // webpackBootstrap
/******/ 	// The module cache
/******/ 	var installedModules = {};
/******/
/******/ 	// The require function
/******/ 	function __webpack_require__(moduleId) {
/******/
/******/ 		// Check if module is in cache
/******/ 		if(installedModules[moduleId]) {
/******/ 			return installedModules[moduleId].exports;
/******/ 		}
/******/ 		// Create a new module (and put it into the cache)
/******/ 		var module = installedModules[moduleId] = {
/******/ 			i: moduleId,
/******/ 			l: false,
/******/ 			exports: {}
/******/ 		};
/******/
/******/ 		// Execute the module function
/******/ 		modules[moduleId].call(module.exports, module, module.exports, __webpack_require__);
/******/
/******/ 		// Flag the module as loaded
/******/ 		module.l = true;
/******/
/******/ 		// Return the exports of the module
/******/ 		return module.exports;
/******/ 	}
/******/
/******/
/******/ 	// expose the modules object (__webpack_modules__)
/******/ 	__webpack_require__.m = modules;
/******/
/******/ 	// expose the module cache
/******/ 	__webpack_require__.c = installedModules;
/******/
/******/ 	// define getter function for harmony exports
/******/ 	__webpack_require__.d = function(exports, name, getter) {
/******/ 		if(!__webpack_require__.o(exports, name)) {
/******/ 			Object.defineProperty(exports, name, {
/******/ 				configurable: false,
/******/ 				enumerable: true,
/******/ 				get: getter
/******/ 			});
/******/ 		}
/******/ 	};
/******/
/******/ 	// getDefaultExport function for compatibility with non-harmony modules
/******/ 	__webpack_require__.n = function(module) {
/******/ 		var getter = module && module.__esModule ?
/******/ 			function getDefault() { return module['default']; } :
/******/ 			function getModuleExports() { return module; };
/******/ 		__webpack_require__.d(getter, 'a', getter);
/******/ 		return getter;
/******/ 	};
/******/
/******/ 	// Object.prototype.hasOwnProperty.call
/******/ 	__webpack_require__.o = function(object, property) { return Object.prototype.hasOwnProperty.call(object, property); };
/******/
/******/ 	// __webpack_public_path__
/******/ 	__webpack_require__.p = "/dist/";
/******/
/******/ 	// Load entry module and return exports
/******/ 	return __webpack_require__(__webpack_require__.s = 0);
/******/ })
/************************************************************************/
/******/ ([
/* 0 */
/***/ (function(module, exports) {

var Employee = React.createClass({
    displayName: "Employee",


    getInitialState: function () {
        return { display: true };
    },
    handleDelete() {
        var self = this;
        $.ajax({
            url: self.props.employee._links.self.href,
            type: 'DELETE',
            success: function (result) {
                self.setState({ display: false });
            },
            error: function (xhr, ajaxOptions, thrownError) {
                toastr.error(xhr.responseJSON.message);
            }
        });
    },
    render: function () {

        if (this.state.display == false) return null;else return React.createElement(
            "tr",
            null,
            React.createElement(
                "td",
                null,
                this.props.employee.name
            ),
            React.createElement(
                "td",
                null,
                this.props.employee.age
            ),
            React.createElement(
                "td",
                null,
                this.props.employee.years
            ),
            React.createElement(
                "td",
                null,
                React.createElement(
                    "button",
                    { className: "btn btn-info", onClick: this.handleDelete },
                    "Delete"
                )
            )
        );
    }
});

var EmployeeTable = React.createClass({
    displayName: "EmployeeTable",


    render: function () {

        var rows = [];
        this.props.employees.forEach(function (employee) {
            rows.push(React.createElement(Employee, { employee: employee, key: employee.name }));
        });

        return React.createElement(
            "table",
            { className: "table table-striped" },
            React.createElement(
                "thead",
                null,
                React.createElement(
                    "tr",
                    null,
                    React.createElement(
                        "th",
                        null,
                        "Name"
                    ),
                    React.createElement(
                        "th",
                        null,
                        "Age"
                    ),
                    React.createElement(
                        "th",
                        null,
                        "Years"
                    ),
                    React.createElement(
                        "th",
                        null,
                        "Delete"
                    )
                )
            ),
            React.createElement(
                "tbody",
                null,
                rows
            )
        );
    }
});

var App = React.createClass({
    displayName: "App",


    loadEmployeesFromServer: function () {

        var self = this;
        $.ajax({
            url: "http://localhost:8080/api/employees"
        }).then(function (data) {
            self.setState({ employees: data._embedded.employees });
        });
    },

    getInitialState: function () {
        return { employees: [] };
    },

    componentDidMount: function () {
        this.loadEmployeesFromServer();
    },

    render() {
        return React.createElement(EmployeeTable, { employees: this.state.employees });
    }
});

ReactDOM.render(React.createElement(App, null), document.getElementById('root'));

/***/ })
/******/ ]);