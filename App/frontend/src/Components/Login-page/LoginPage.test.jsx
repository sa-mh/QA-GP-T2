import userEvent from '@testing-library/user-event';
import LoginForm from './LoginPage.jsx';
import { fireEvent, render } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';

describe('Login Page Testing',()=>{

const mockSubmitFunction = jest.fn();
const d_Username= "JDoe";
const d_Password= "QA-TEST-P4SS";
const d_Trainee = "Trainee";
const d_Trainer = "Trainer";

it('should check if the username updates', () => {
    const {container} = render(<Router><LoginForm/></Router>);
    const usernameInput = container.querySelector('[name="username"]');
    expect(usernameInput.value).toEqual('');

    userEvent.type(usernameInput,d_Username);

    expect(usernameInput.value).toEqual(d_Username);
});


it('should check if password updates', () => {
    const {container} = render(<Router><LoginForm/></Router>);
    const passwordInput = container.querySelector('[name="password"]');
    expect(passwordInput.value).toEqual('');

    userEvent.type(passwordInput,d_Password);

    expect(passwordInput.value).toEqual(d_Password);
});

it('should check if MemberSelector updates', () => {
    const {container} = render(<Router><LoginForm/></Router>);
    const memberVar = container.querySelector('[name="traineeTrainer"]');
    expect(memberVar.value).toEqual('');

    userEvent.selectOptions(memberVar,d_Trainee)
    
    expect(memberVar.value).not.toEqual(d_Trainer);

    userEvent.selectOptions(memberVar,d_Trainer);

    expect(memberVar.value).toEqual(d_Trainer);

});

it('should call the handleSubmit function', () => {
    const {container} = render(<Router><LoginForm/></Router>);
    const passwordInput = container.querySelector('[name="username"]');
    const usernameInput = container.querySelector('[name="email"]');
    const trainerTrainee = container.querySelector('[name="traineeTrainer"]');
    const submitButton = container.querySelector('[type="submit"]');
    submitButton.onClick = mockSubmitFunction();
    
    userEvent.type(passwordInput, d_Password);
    userEvent.type(usernameInput,d_Username);
    userEvent.selectOptions(trainerTrainee,d_Trainee);
    fireEvent.click(submitButton);

    expect(mockSubmitFunction).toHaveBeenCalled();

});

});