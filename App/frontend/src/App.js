import './App.css';
import Footer from './Components/Footer';
import Header from './Components/Header';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import LoginPage from './Components/Login-page/LoginPage';
import Aboutpage from './Components/About-page/Aboutpage';
import CreateAccount from './Components/Create-Account-page/CreateAccount';
import PostIssues from './Components/Trainee/PostIssues/PostIssues';
import ManageIssues from './Components/Trainee/Account/ManageIssues/ManageIssues';
import ViewAllIssues from './Components/Trainer/ViewAllIssues';
// import TrainerPage from './Components/Trainer/';
import IpContext from './IpContext';
import { useContext } from 'react';

const ip = "54.194.254.129:8081"

function App() {
  return (
    <Router>
      <Header />
      <IpContext.Provider value = {ip}>
      <Switch>
        <Route path="/login" component={LoginPage} />
        <Route path="/about" component={Aboutpage} />
        <Route path="/createAccount" component={CreateAccount} />
        <Route path="/postIssue" component={PostIssues} />
        <Route path="/ViewAllIssues" component={ViewAllIssues} />
        <Route path="/manageIssues" component={ManageIssues} />

        {/* <Route path="/trainee" component={Trainee}/>
            <Route path="/trainer" component={Trainer}/> */}
      </Switch>
      </IpContext.Provider>
             <Footer />
    </Router>
  );
}

export default App;
