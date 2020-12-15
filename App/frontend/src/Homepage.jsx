import React from 'react';
import { Link } from 'react-router-dom'

const Homepage = () => {

    return (
        <div id="root-home">

          <div>
              <h1 id="home-first-line">SHARE YOUR ISSUES</h1>
              <h5 id="home-second-line">Share any problems you are facing with your projects and a trainer will respond to you within 24 hours</h5>
              <div class="home-buttons">
              
              <Link to="/login">
              <button class="home-button-item" id="home-button-post">Post an Issue</button>
              </Link>
              
              <Link to="/createAccount">
                  <button class="home-button-item" id="home-button-createAccount">Create an account</button>
                  </Link>
              </div>
              </div>  

        </div>
    );
}

export default Homepage;