import React,{Component} from 'react';
import {baseURL} from '../Utils/RestUtils';


class RestEndpoint extends Component {
  state={

    
  }

  componentDidMount(){


  }


  render(){
  return (
    <div>
          <div className="card">
            <div className="card-body">
                <h5 className="card-title">{this.props.data.name}</h5>
                <a href={baseURL+"/simulator"+this.props.data.url} >{baseURL+"/simulator"+this.props.data.url}</a>
            </div>
            </div>
    </div>
  );
  }


}

export default RestEndpoint;
