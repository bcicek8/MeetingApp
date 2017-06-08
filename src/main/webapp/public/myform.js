var BasicInputBox = React.createClass ({
  render: function (){
    return (
     <div>
       <label>{this.props.label}</label>
       <br/>
       <input type="text" onChange={this.props.valChange} value= {this.props.val} />
       <br/> 
     </div>
    );
  }
 });
 
 var myForm = React.createClass({
    getInitialState: function(){
      return {}
    },
    
    submit: function (e){
      var self
      
      e.preventDefault()
      self = this

      console.log(this.state);

      var data = {
        name: this.state.name,
        id: this.state.id,
      }

      $.ajax({
        type: 'POST',
        url: "http://localhost:8080/api/employee/",
        data: JSON.stringify(data),
        contentType: "application/json",
      })
      .done(function(data) {
        self.clearForm()
      })
      .fail(function(jqXhr) {
        console.log('failed to register');
        console.log(jqXhr);
        toastr.error(jqXhr.responseJSON.path);
      });

    },

    clearForm: function() {
      this.setState({
        name: "",
        id: ""
      });
    },

    nameChange: function(e){
      this.setState({name: e.target.value})
    },
    
    idChange: function(e){
     this.setState({id: e.target.value})
    },

    render: function(){
       return (
        <form onSubmit={this.submit} >
        <div className="form-group">
	        <div className="col-md-2">
	          <BasicInputBox label="Name:" valChange={this.nameChange} val={this.state.name}/>
	        </div>
	        <div className="col-md-2">
	          <BasicInputBox label="Department ID:" valChange={this.idChange} val={this.state.id}/>
	        </div>
	        <div className="col-md-2">
	          <button className="btn btn-success" type="submit">Submit</button>
	        </div>
        </div>
        </form>
      );
    }
});

 ReactDOM.render(<myForm />, document.getElementById('my-form') );