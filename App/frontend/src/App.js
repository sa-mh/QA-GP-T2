import './App.css';
import Footer from './Components/Footer';
import Header from './Components/Header';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import LoginPage from './Components/Login-page/LoginPage';
import Aboutpage from './Components/About-page/Aboutpage';
import CreateAccount from './Components/Create-Account-page/CreateAccount';
import PostIssues from './Components/Trainee/PostIssues/PostIssues';
import ManageIssues from './Components/Trainee/Account/ManageIssues/ManageIssues';
// import TrainerPage from './Components/Trainer/';

function App() {
  return (
      <Router>
        <Header />
        <Switch>
            <Route path="/login" component={LoginPage}/>
            <Route path="/about" component={Aboutpage}/>
            <Route path="/createAccount" component={CreateAccount}/>
            <Route path="/postIssue" component={PostIssues}/>
             <Route path="/trainee" component={ManageIssues}/> 
            {/*<Route path="/trainer" component={Trainer}/>*/}
        </Switch>
        <Footer />
      </Router>
  );
}

export default App;
