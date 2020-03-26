import React,{Component} from 'react';
import {getRequest,postRequest} from '../Utils/RestUtils';


class RestEndpointDetail extends Component {
  state={
        name:"",
        description:"",
        url:"",
        responseBody:""
    
  }

  componentDidMount(){


  }

  setName = e=>this.setState({name:e.target.value});
  setDescription = e=>this.setState({description:e.target.value});
  setUrl = e=>this.setState({url:e.target.value});
  setResponseBody = e=>this.setState({responseBody:e.target.value});

  onSubmit = e=>{
      e.preventDefault();
      console.dir(this.state);
      this.props.registerNewRestService(this.state);
  }

  render(){
  return (
    <div>
        <form className="m-6">
        <div className="form-group">
            <label>Name</label>
            <input type="text" className="form-control" id="name" onChange={this.setName}></input>
        </div>

        <div className="form-group">
            <label>Description</label>
            <input type="text" className="form-control" id="description" onChange={this.setDescription}></input>
        </div>

        <div className="form-group">
            <label>URL</label>
            <input type="text" className="form-control" id="url" onChange={this.setUrl}></input>
        </div>

        <div className="form-group">
            <label>Response Body</label>
            <input type="text" className="form-control" id="responsebody" onChange={this.setResponseBody}></input>
        </div>

        <button type="submit" className="btn m-2 btn-primary" onClick={this.onSubmit}>Add</button>
        </form>
    </div>
  );
  }


}

export default RestEndpointDetail;
