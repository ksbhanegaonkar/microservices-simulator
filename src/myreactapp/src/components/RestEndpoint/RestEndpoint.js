import React,{Component} from 'react';



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
                <a href="#" className="btn btn-primary">{this.props.data.url}</a>
            </div>
            </div>
    </div>
  );
  }


}

export default RestEndpoint;
