import './App.css';
import Footer from './Components/Footer';
import Header from './Components/Header';

function App() {
  return (
      <Router>
        <Header />
        <Switch>
          <div>
            <Route path="/" exact component={HomePage}/>
            <Route path="/login" exact component={loginPage}/>
            <Route path="/about" exact component={aboutPage}/>
          </div>
        </Switch>
        <Footer />
      </Router>
  );
}

export default App;
