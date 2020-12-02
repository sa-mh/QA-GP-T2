import React, {useState} from 'react'

const PostIssues = () => {

    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");

    const updateTitle = (e) => {
        e.preventDefault(); 
        setTitle(e.target.value);
    }

    const updateDesciption = (e) => {
        e.preventDefault(); 
        setDescription(e.target.value);
    }


    return (
        <div>
        <div className="createDiv">
            <h1 className="signupHeading">Post an issue</h1>
            <div>
            <form className="ml-3" id="postIssueForm">
                    <input className="issueInput" type="text"  onChange={(e) => updateTitle(e)} placeholder="Give issue a title" required></input> <br></br>
                    <input className="issueInput" type="text"  onChange={(e) => updateDesciption(e)}placeholder="Please explain the issue in as much detail as possible" required></input> <br></br>
                    <button className="btn btn-primary" id="signupButton" type="submit">Post Issue</button>
                </form>
            </div>
        </div>
    </div>
    )

}
export default PostIssues;

