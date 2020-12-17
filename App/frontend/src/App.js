import './App.css';
import Footer from './Components/Footer';
import Header from './Components/Header';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Aboutpage from './Components/About-page/Aboutpage';
import PostIssues from './Components/Trainer/PostIssues/PostIssues';
import ViewAllIssues from './Components/Trainer/ViewAllIssues';
import IpContext from './IpContext';
import Homepage from './Homepage';

function App() {
  return (
    <Router>
      <Header />
        <Switch>
          <Route path="/" exact component={Homepage} />
          <Route path="/about" component={Aboutpage} />
          <Route path="/postIssue" component={PostIssues} />
          <Route path="/ViewAllIssues" component={ViewAllIssues} />

          {/* <Route path="/trainee" component={Trainee}/>
            <Route path="/trainer" component={Trainer}/> */}
        </Switch>
      <Footer />
    </Router>
  );
}

export default App;
