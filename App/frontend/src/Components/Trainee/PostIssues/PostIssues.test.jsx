import userEvent from '@testing-library/user-event';
import PostIssues from './PostIssues.jsx';
import { fireEvent, render } from '@testing-library/react';

describe('Posting Issues Testing',()=>{

    const mockSubmitFunction = jest.fn();
    const d_title = "Help!";
    const d_issue= "I can't get Project 3 working!";
    const d_topicTag= "React";
    const d_topic= "React";
    const d_priority = "1";
    const d_priorityTag = "High";
    const d_status = "Open";
    const d_traineeid = "1";

    it('should check if the title updates', () => {
        const {container} = render(<PostIssues/>);
        const titleInput = container.querySelector('[id="Title"]');
        expect(titleInput.value).toEqual('');
    
        userEvent.type(titleInput,d_title);
    
        expect(titleInput.value).toEqual(d_title);
    });

    it('should check if the issue updates', () => {
        const {container} = render(<PostIssues/>);
        const issueInput = container.querySelector('[id="Issue"]');
        expect(issueInput.value).toEqual('');
    
        userEvent.type(issueInput,d_issue);
    
        expect(issueInput.value).toEqual(d_issue);
    });
    
    it('should check if Topic updates', () => {
        const {container} = render(<PostIssues/>);
        const topicInput = container.querySelector('[id="Topic"]');
        expect(topicInput.value).toEqual('');

        userEvent.selectOptions(topicInput, d_topicTag)
    
        expect(topicInput.value).toEqual(d_topic);
    });

    it('should check if Priority updates', () => {
        const {container} = render(<PostIssues/>);
        const priorityInput = container.querySelector('[id="Priority"]');
        expect(priorityInput.value).toEqual('');

        userEvent.selectOptions(priorityInput, d_priorityTag)
    
        expect(priorityInput.value).toEqual(d_priority);
    });

    it('should call the handleSubmit function for posting issues', () => {
        const {container} = render(<PostIssues onSubmit={mockSubmitFunction}/>);
        const titleInput = container.querySelector('[id="Title"]');
        const issueInput = container.querySelector('[id="Issue"]');
        const topicInput = container.querySelector('[id="Topic"]');
        const priorityInput = container.querySelector('[id="Priority"]');
        const accountSubmit = container.querySelector('[id="postButton"]');
        const accountForm = container.querySelector('[id="postIssueForm"]');
        // accountForm.onSubmit={mockSubmitFunction}
        // console.log(accountForm);
        
        userEvent.type(titleInput, d_title);
        userEvent.type(issueInput, d_issue);
        userEvent.selectOptions(topicInput, d_topicTag);
        userEvent.selectOptions(priorityInput, d_priorityTag);
        fireEvent.submit(accountForm);
    
        expect(mockSubmitFunction).toHaveBeenCalled();
        expect(mockSubmitFunction).toHaveBeenCalledWith({
            title: d_title,
	        issue: d_issue,
	        topic: d_topic,
            urgency: d_priority,
	        status: d_status,
	        traineeID: d_traineeid,
            });
    
    });



});