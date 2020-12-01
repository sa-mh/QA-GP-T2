import './App.css';
import Footer from './Components/Footer';
import Header from './Components/Header';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import LoginPage from './Components/Login-page/LoginPage';
import Aboutpage from './Components/About-page/Aboutpage';
import CreateAccount from './Components/Create-Account-page/CreateAccount';


function App() {
  return (
      <Router>
        <Header />
        <Switch>
          <div>
            <Route path="/login" exact component={LoginPage}/>
            <Route path="/about" exact component={Aboutpage}/>
            <Route path ="/createAccount" component={CreateAccount}/>

          </div>
        </Switch>
        <Footer />
      </Router>
  );
}

export default App;
