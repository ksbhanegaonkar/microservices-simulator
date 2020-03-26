import React,{Component} from 'react';
import './WelcomePage.css';
import RestEndpoint from '../RestEndpoint/RestEndpoint';
import {getRequest,postRequest} from '../Utils/RestUtils';
import RestEndpointDetail from '../RestEndpoint/RestEndpointDetail';



class WelcomePage extends Component {
  state={
    restEndpoints : []
    
  }



  componentDidMount(){



    getRequest("getallrestservices",data => this.setState({restEndpoints:data}));

  }

  registerNewRestService(s){
    postRequest("registerservice",s,(data)=>{
      console.dir(data);
      //let newRestEndpoints =this.setState.restEndpoints;
     // newRestEndpoints.push(data);
      this.setState({restEndpoints : [...this.state.restEndpoints, data]});
    })
  }


  render(){
  return (
    <div>
        <div className="container border border-primary">
        <div className="row border border-primary col-5" >
            <div className="col-6 m-3">
            <button type="button" className="btn btn-success">Add New Rest Service</button>
            </div>
          </div>

          <div className="row">
            <div className="col-md-5 ">
            {this.renderRestEndpointList()}
            </div>
            <div className="col-sm border border-primary ">
             Rest Service Detail
             <RestEndpointDetail registerNewRestService={this.registerNewRestService.bind(this)}></RestEndpointDetail>
            </div>
          </div>


        </div>


       
    </div>
  );
  }


  renderRestEndpointList(){
    return this.state.restEndpoints.map(r => {
      return (<div className="m-3"><RestEndpoint data={r}></RestEndpoint></div>);
    })
  }

}

export default WelcomePage;
