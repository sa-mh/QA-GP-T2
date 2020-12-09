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

function App() {
  return (
      <Router>
        <Header />
        <ManageIssues />
        <Footer />
      </Router>
  );
}

export default App;
