import React,{Component} from 'react';



class RestEndpointDetail extends Component {
  state={

    
  }

  componentDidMount(){


  }


  render(){
  return (
    <div>
        <form className="m-6">
        <div className="form-group">
            <label for="name">Name</label>
            <input type="text" className="form-control" id="name"></input>
        </div>

        <div className="form-group">
            <label for="description">Description</label>
            <input type="text" className="form-control" id="description"></input>
        </div>

        <div className="form-group">
            <label for="url">URL</label>
            <input type="text" className="form-control" id="url"></input>
        </div>

        <div className="form-group">
            <label for="responsebody">Response Body</label>
            <input type="text" className="form-control" id="responsebody"></input>
        </div>

        <button type="submit" className="btn btn-primary">Add</button>
        </form>
    </div>
  );
  }


}

export default RestEndpointDetail;
