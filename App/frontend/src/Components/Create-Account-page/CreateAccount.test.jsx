import userEvent from '@testing-library/user-event';
import CreateAccount from './CreateAccount.jsx';
import { fireEvent, render } from '@testing-library/react';

describe('Create Account Page Testing',()=>{

    const mockSubmitFunction = jest.fn();
    const d_username = "JDoe";
    const d_firstName= "Jordan";
    const d_lastName= "Doe";
    const d_cohort = "Cloud Native";
    const d_password = "D0£";
    const d_email = "JDorian@academytrainee.com";

    it('should check if the username updates', () => {
        const {container} = render(<CreateAccount/>);
        const usernameInput = container.querySelector('[id="username"]');
        expect(usernameInput.value).toEqual('');
    
        userEvent.type(usernameInput,d_username);
    
        expect(usernameInput.value).toEqual(d_username);
    });

    it('should check if the first name updates', () => {
        const {container} = render(<CreateAccount/>);
        const firstNameInput = container.querySelector('[id="first-name"]');
        expect(firstNameInput.value).toEqual('');
    
        userEvent.type(firstNameInput,d_firstName);
    
        expect(firstNameInput.value).toEqual(d_firstName);
    });
    
    it('should check if the last name updates', () => {
        const {container} = render(<CreateAccount/>);
        const lastNameInput = container.querySelector('[id="last-name"]');
        expect(lastNameInput.value).toEqual('');
    
        userEvent.type(lastNameInput,d_lastName);
    
        expect(lastNameInput.value).toEqual(d_lastName);
    });

    it('should check if the email updates', () => {
        const {container} = render(<CreateAccount/>);
        const emailInput = container.querySelector('[id="qa_email"]');
        expect(emailInput.value).toEqual('');
    
        userEvent.type(emailInput,d_email);
    
        expect(emailInput.value).toEqual(d_email);
    });

    it('should check if cohort updates', () => {
        const {container} = render(<CreateAccount/>);
        const cohortInput = container.querySelector('[id="cohort"]');
        expect(cohortInput.value).toEqual('');

        userEvent.selectOptions(cohortInput, d_cohort)
    
        expect(cohortInput.value).toEqual(d_cohort);
    });

    it('should check if password updates', () => {
        const {container} = render(<CreateAccount/>);
        const passwordInput = container.querySelector('[id="password1"]');
        expect(passwordInput.value).toEqual('');
    
        userEvent.type(passwordInput,d_password);
    
        expect(passwordInput.value).toEqual(d_password);
    });

    it('should call the handleSubmit function for trainee', () => {
        const {container} = render(<CreateAccount onSubmit={mockSubmitFunction}/>);
        const usernameInput = container.querySelector('[id="username"]');
        const firstNameInput= container.querySelector('[id="first-name"]');
        const lastNameInput= container.querySelector('[id="last-name"]');
        const cohortInput = container.querySelector('[id="cohort"]');
        const passwordInput = container.querySelector('[id="password1"]');
        const passwordInput2 = container.querySelector('[id="password2"]');
        const emailInput = container.querySelector('[id="qa_email"]');
        const accountSubmit = container.querySelector('[id="signupButton"]');
        const accountForm = container.querySelector('[id="signupForm"]');
        // accountForm.onSubmit={mockSubmitFunction}
        // console.log(accountForm);
        
        userEvent.type(usernameInput, d_username);
        userEvent.type(firstNameInput, d_firstName);
        userEvent.type(lastNameInput, d_lastName);
        userEvent.type(passwordInput, d_password);
        userEvent.type(passwordInput2, d_password);
        userEvent.type(emailInput, d_email);
        userEvent.selectOptions(cohortInput, d_cohort);
        fireEvent.click(accountSubmit);
    
        expect(mockSubmitFunction).toHaveBeenCalled();
        expect(mockSubmitFunction).toHaveBeenCalledWith({
            username : d_username,
            firstName : d_firstName,
            lastName : d_lastName,
            cohort : d_cohort,
            password : d_password,
            traineeEmail : d_email
            });
    
    });



});