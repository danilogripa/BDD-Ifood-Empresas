Feature: Registration Form

  Background:
    Given I reached the registration form page from IFood


  Scenario: Do the registration filling all the informations
    When I fill all the registration form
    And I click the checkbox
    And I click enviar
    Then I need to see the thank you message

  Scenario: Do the registration filling all the informations but no click in the checkbox
    When I fill all the registration form
    And I click enviar
    Then I need to see the thank you message


  Scenario Template: I Forgot to fill the <id> information
    When I fill all the registration form this way
      | name     | <name>    |
      | tel | <tel> |
      | email | <email> |
      | companyName    | <companyName>    |
      | qttEmps | <qttEmps> |
      | cnpj | <cnpj> |
      | selectMenu    | <selectMenu>    |
    And I click enviar
    Then I need to see the message that says it is missing the information
    Examples:
      | id                  | name                | tel         | email          | companyName  | qttEmps | cnpj           | selectMenu |
      | Name                |                     | 21987675645 | test@gmail.com | Starving inc | 12      | 16453128000140 | yes        |
      | Phone Number        | Roger Federer Obama |             | test@gmail.com | Starving inc | 12      | 16453128000140 | yes        |
      | Email               | Roger Federer Obama | 21987675645 |                | Starving inc | 12      | 16453128000140 | yes        |
      | Company Name        | Roger Federer Obama | 21987675645 | test@gmail.com |              | 12      | 16453128000140 | yes        |
      | Number of Employees | Roger Federer Obama | 21987675645 | test@gmail.com | Starving inc |         | 16453128000140 | yes        |
      | CNPJ                | Roger Federer Obama | 21987675645 | test@gmail.com | Starving inc | 12      |                | yes        |
      | Select Menu         | Roger Federer Obama | 21987675645 | test@gmail.com | Starving inc | 12      | 16453128000140 |            |


  Scenario Template: I fill the <id> with a wrong information
    When I fill all the registration form this way
      | name     | <name>    |
      | tel | <tel> |
      | email | <email> |
      | companyName    | <companyName>    |
      | qttEmps | <qttEmps> |
      | cnpj | <cnpj> |
      | selectMenu    | <selectMenu>    |
    When I press enviar
    Then I need to see the message that says it is missing the information
    Examples:
      | id                  | name                | tel         | email          | companyName  | qttEmps | cnpj           | selectMenu |
      | Phone Number        | Roger Federer Obama | testnumber  | test@gmail.com | Starving inc | 12      | 16453128000140 | yes        |
      | Email               | Roger Federer Obama | 21987675645 | 21987675645    | Starving inc | 12      | 16453128000140 | yes        |
      | Number of Employees | Roger Federer Obama | 21987675645 | test@gmail.com | Starving inc | ABC     | 16453128000140 | yes        |
      | CNPJ                | Roger Federer Obama | 21987675645 | test@gmail.com | Starving inc | 12      | 1234           | yes        |