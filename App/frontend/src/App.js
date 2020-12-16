import './App.css';
import Footer from './Components/Footer';
import Header from './Components/Header';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Aboutpage from './Components/About-page/Aboutpage';
import PostIssues from './Components/Trainee/PostIssues/PostIssues';
import ViewAllIssues from './Components/Trainer/ViewAllIssues';
import IpContext from './IpContext';
import { useContext } from 'react';
import Homepage from './Homepage';

const ip = "localhost:8081"

function App() {
  return (
    <Router>
      <Header />
      <IpContext.Provider value={ip}>
        <Switch>
          <Route path="/" exact component={Homepage} />
          <Route path="/about" component={Aboutpage} />
          <Route path="/postIssue" component={PostIssues} />
          <Route path="/ViewAllIssues" component={ViewAllIssues} />

          {/* <Route path="/trainee" component={Trainee}/>
            <Route path="/trainer" component={Trainer}/> */}
        </Switch>
      </IpContext.Provider>
      <Footer />
    </Router>
  );
}

export default App;
