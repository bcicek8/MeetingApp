var Department = React.createClass({

  getInitialState: function() {
    return {display: true };
  },
  handleDelete() {
    var self = this;
    //console.log(self);
    $.ajax({
        url: "http://localhost:8080/api/department/" + self.props.department.id,
        type: 'DELETE',
        success: function(result) {
          self.setState({display: false});
        },
        error: function(xhr, ajaxOptions, thrownError) {
          toastr.error(xhr.responseJSON.message);
        }
    });
  },
  render: function() {

    if (this.state.display==false) return null;
    else return (
      <tr>
          <td>{this.props.department.departmentId}</td>
          <td>{this.props.department.name}</td>
          <td>{this.props.department.description}</td>
          <td>
            <button className="btn btn-info" onClick={this.handleDelete}>Delete</button>
          </td>
      </tr>
    );
  }
});

var DepartmentTable = React.createClass({

  render: function() {

    var rows = [];
    this.props.departments.forEach(function(department) {
      rows.push(
        <Department department={department} key={department.id} />);
    });

    return (
      <table className="table table-striped">
          <thead>
              <tr>
                  <th>Department ID</th>
                  <th>Name</th>
                  <th>Description</th>
                  <th>Delete</th>
              </tr>
          </thead>
          <tbody>{rows}</tbody>
      </table>
    );
  }
});

var App = React.createClass({

  loadFromServer: function() {

    var self = this;
    $.ajax({
        url: "http://localhost:8080/api/departments",
      }).then(function(data) {
        self.setState({ departments: data });
      });

  },

  getInitialState: function() {
    return { departments: [] };
  },

  componentDidMount: function() {
    this.loadFromServer();
  },

  render() {
    return ( <DepartmentTable departments={this.state.departments} /> );
  }
});

ReactDOM.render(<App />, document.getElementById('root') );