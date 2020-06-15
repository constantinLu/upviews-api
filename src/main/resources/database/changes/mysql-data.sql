#HRIS TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.HRIS (ID, FIRST_NAME, LAST_NAME, USER_NAME,  EMAIL, PHONE_NUMBER, BUSINESS_UNIT, UNIT, TECHNICAL_POSITION)
VALUES
(10, 'Gheorghe', 'Manzat', 'gmanzat', 'ghmanzat@fortech.ro', '0753212333', 'BU1', 'U1.4', 'Project Manager'),
(40, 'Beatrice', 'Toma', 'btoma', 'toma@gmail.com', '077878788', 'BU1', 'U1.4', 'Back-End Developer'),
(20, 'Cristina', 'Manolache', 'cmanolache', 'manolache@gmail.com', '0721332390', 'BU1', 'U1.4', 'Java Developer'),
(30, 'Ionica', 'Vanzatoru', 'ivanzatoru', 'vanzatoru@gmail.com', '0741009234', 'BU1', 'U1.4', 'Java Developer');

INSERT INTO E_RESUME.HRIS (ID, FIRST_NAME, LAST_NAME, USER_NAME,  EMAIL, PHONE_NUMBER, BUSINESS_UNIT, UNIT, TECHNICAL_POSITION, SUPERVISOR_ID)
VALUES
(1, 'Florin', 'Tansanu', 'ftansanu', 'tansanu@fortech.ro', '0723211323', 'BU1', 'U1.4', 'Team Lead', 10),
(2, 'Constantin', 'Lungu', 'clungu', 'lungu@fortech.ro', '0757212233', 'BU1', 'U1.4', 'Software Developer', 1),
(3, 'Madalina', 'Magdalena', 'mmagdalena', 'magdalena@fortech.ro', '0759243332', 'BU1', 'U1.4', 'Java Developer', 1);



#RESUME TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.RESUME (ID, USER_ID)
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 10);


#EXPERIENCE TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.EXPERIENCE (ID, JOB_TITLE, COMPANY, LOCATION, START_DATE, END_DATE, RESPONSIBILITIES, RESUME_ID)
VALUES (1, 'Software Team Lead', 'EA Games', 'Bucharest', STR_TO_DATE('01-02-2015', '%d-%m-%Y'),
        STR_TO_DATE('01-10-2017', '%d-%m-%Y'),
        '- Haxe development - a cross platform toolkit that targets all the mainstream platforms natively
        - GAME development
        - Driving multiple projects to completion
        - Worked on distributed agile teams',
        1),
(2, 'Software Team Lead', 'Tesla', 'San Francisco', STR_TO_DATE('01-01-2018', '%d-%m-%Y'),
        STR_TO_DATE('01-05-2018', '%d-%m-%Y'),
        '- Ai development
        - ECU development
        - Documentation
        - Worked on distributed agile teams',
        1),
(3, 'Software Developer', 'EOS Software', 'Stuttgart', STR_TO_DATE('01-02-2016', '%d-%m-%Y'),
        STR_TO_DATE('01-07-2016', '%d-%m-%Y'), 'Providing second line technical support for more complex incidents received from the 1st line incident handlers;
            - Acting as first point of escalation for the service desk;
            - Active Directory Management – Computer, Users, Groups, Distribution
            Lists;
            - Network connectivity troubleshooting;
            ▪ Remote Access User Management and troubleshooting;
            ▪ Microsoft Office troubleshooting;
            ▪ Windows XP, 7, 10 troubleshooting;',
        2),
(4, 'GIS Developer', 'ACADIS Software', 'Amsterdam', STR_TO_DATE('01-07-2016', '%d-%m-%Y'),
        STR_TO_DATE('01-04-2018', '%d-%m-%Y'), 'Developing scripts to automate geoprocessing task with Python;
    ▪ Gather, analyze, integrate spatial data and determine how best the
    information can be displayed using GIS and tools based on python scripts;
    ▪ Creating and processing data layers, shape files, tables or reports;
    ▪ Manipulating data through SQL queries;
    ▪ Doing all kinds of analysis for various type of studies such as environmental
    impact assessment studies, environmental road traffic and industrial noise
    and air quality surveys.',
        2);


#TRAINING TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.TRAINING (ISSUING_ORGANISATION, TRAINING_NAME, ISSUING_DATE, RESUME_ID) VALUES
('Coursera', 'Java Object Oriented Programming', '2016-01-20', '1'),
('Coursera', 'Beginning with Java', '2013-01-01', '1'),
('Coursera', 'Introduction to Sql', '2014-01-01', '2'),
('Udemy', 'Spring Boot Microservices', '2019-01-01', '2'),
('Coursera', 'Python for Beginners', '2011-01-01', '1');


#LANGUAGE TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.LANGUAGE (LANGUAGE_NAME)
VALUES
('English'),
('French'),
('Mandarin'),
('Spanish'),
('Arab'),
('Russian'),
('German'),
('Japanese'),
('Portuguese'),
('Hindu'),
('Hungarian'),
('Ukrainian'),
('Italian'),
('Chinese'),
('Greek'),
('Polish'),
('Serbian');


#LANGUAGE_SECTION TABLE---------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.LANGUAGE_SECTION (ID, LEVEL, READ_LEVEL, WRITE_LEVEL, SPEAK_LEVEL, LISTEN_LEVEL, LANGUAGE_ID, RESUME_ID) VALUES
('1', 'BEGINNER', 'A1', 'A1', 'A1', 'A1', '1', '1'),
('2', 'INTERMEDIARY', 'B1', 'B1', 'B1', 'B1', '2', '1'),
('3', 'ADVANCED', 'B1', 'A1', 'B1', 'C1', '5', '2'),
('4', 'ADVANCED', 'B1', 'C1', 'B1', 'C2', '4', '2');


#ROLE TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.ROLE (ROLE_NAME)
VALUES
('Software Developer'),
('Frontend Developer'),
('Manager'),
('Business Analyst'),
('Scrum Master'),
('Product Owner'),
('Technical Lead'),
('Tester');


#TECHNOLOGY TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.TECHNOLOGY (ID, TECHNOLOGY_NAME)
VALUES
('1', 'JAVA 8'),
('2', 'JAVA EE'),
('3', 'SOAP WS'),
('4', 'REST'),
('5', 'JSF'),
('6', 'GIT'),
('7', 'REST WS'),
('8', 'Spring Security'),
('9', 'Spring Data'),
('10', 'Spring Boot');



#DATABASE TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.DB (ID, DB_NAME)
VALUES
('1', 'MySQL'),
('2', 'OracleDB'),
('3', 'Cassandra'),
('4', 'MariaDB'),
('5', 'PostgreSQL'),
('6', 'SQL Server'),
('7', 'REST WS'),
('8', 'Redis'),
('9', 'IBM DB2'),
('10', 'MongoDB');


#DEV_TOOL TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.DEV_TOOL (ID, DEV_TOOL_NAME)
VALUES
('1', 'Intellj'),
('2', 'Eclipse'),
('3', 'Git'),
('4', 'Maven'),
('5', 'Svn'),
('6', 'Vim'),
('7', 'Gerrit'),
('8', 'Notepad++'),
('9', 'Jira'),
('10', 'Workspace');


#TEST_TOOL TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.TEST_TOOL (ID, TEST_TOOL_NAME)
VALUES
('1', 'Test Studio'),
('2', 'Cucumber'),
('3', 'Silk Test'),
('4', 'Selenium'),
('5', 'Appium'),
('6', 'Jasmine'),
('7', 'JTest'),
('8', 'QF Test'),
('9', 'Screenster'),
('10', 'HP WinRunner');


#METHODOLOGY TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.METHODOLOGY (ID, METHODOLOGY_NAME)
VALUES
('1', 'Agile'),
('2', 'Waterfall'),
('3', 'Scrum'),
('4', 'Kaban'),
('5', 'Test-Driven Development'),
('6', 'Extreme Programming'),
('7', 'Prototype'),
('8', 'Rapid Application Development'),
('9', 'Dynamic System Development Model'),
('10', 'Spiral Model');


#OPERATION_SYSTEM TABLE--------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.OPERATION_SYSTEM (ID, OS_NAME)
VALUES
('1', 'Windows XP'),
('2', 'Windows 7'),
('3', 'Windows 8'),
('4', 'Windows 10'),
('5', 'Linux'),
('6', 'MacOS'),
('7', 'Kali'),
('8', 'Ubuntu'),
('9', 'Debian'),
('10', 'Fedora');


#EDUCATION TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.EDUCATION (ID, INSTITUTION, DEGREE, START_DATE, END_DATE, RESUME_ID)
VALUES
(1, 'CNRV', 'baccalaureate', STR_TO_DATE('01-09-2012', '%d-%m-%Y'), STR_TO_DATE('01-07-2016', '%d-%m-%Y'), 1),
(2, 'UAIC', 'bachelor', STR_TO_DATE('01-09-2016', '%d-%m-%Y'), STR_TO_DATE('01-06-2019', '%d-%m-%Y'), 1),
(3, 'CN', 'baccalaureate', STR_TO_DATE('01-09-2010', '%d-%m-%Y'), STR_TO_DATE('01-07-2014', '%d-%m-%Y'), 2),
(4, 'UAIC', 'bachelor', STR_TO_DATE('01-10-2014', '%d-%m-%Y'), STR_TO_DATE('01-07-2017', '%d-%m-%Y'), 2),
(5, 'Gheorghe Asachi Technical University', 'master', STR_TO_DATE('01-10-2017', '%d-%m-%Y'), STR_TO_DATE('01-07-2019', '%d-%m-%Y'), 2);


#PROJECT TABLE-----------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.PROJECT (ID, NAME, DESCRIPTION, RESUME_ID)
VALUES
('1', 'UNITE', 'Dealership Application', '1'),
('2', 'Diba', 'Mercedes-Benz User Manual', '2'),
('3', 'Secur', 'Security login microservice', '1'),
('4', 'Coca-Cola', 'Commercial App', '2'),
('5', 'Audi', 'Configration App', '1');


#PROFESSIONAL_SUMMARY TABLE-------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.PROFESSIONAL_SUMMARY (ID, SOFT_SKILL, RESUME_ID)
VALUES
('1', 'Fast-learner. Punctuality. Negotiation. Verbal communication', '1'),
('2', 'Teamwork. Creativity. Flexibility. Integrity', '2');

#PROJECT_ROLE TABLE------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.PROJECT_ROLE (PROJECT_ID, ROLE_ID)
VALUES
('1', '1'),
('1', '7'),
('2', '2'),
('2', '1'),
('2', '3'),
('2', '4');


#PROJECT_TECHNOLOGY TABLE------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.PROJECT_TECHNOLOGY (PROJECT_ID, TECHNOLOGY_ID)
VALUES
('1', '1'),
('1', '2'),
('1', '3'),
('2', '10'),
('1', '9');



#PROFESSIONAL_SUMMARY_DB TABLE--------------------------------------------------------------------------------
INSERT INTO E_RESUME.PROFESSIONAL_SUMMARY_DB (PROFESSIONAL_SUMMARY_ID, DB_ID)
VALUES
('1', '1'),
('1', '2'),
('1', '3'),
('2', '10'),
('1', '9');


#PROFESSIONAL_SUMMARY_DEV_TOOL TABLE--------------------------------------------------------------------------------
INSERT INTO E_RESUME.PROFESSIONAL_SUMMARY_DEV_TOOL (PROFESSIONAL_SUMMARY_ID, DEV_TOOL_ID)
VALUES
('1', '1'),
('1', '2'),
('1', '3'),
('2', '10'),
('1', '9');



#PROFESSIONAL_SUMMARY_TEST_TOOL TABLE--------------------------------------------------------------------------------
INSERT INTO E_RESUME.PROFESSIONAL_SUMMARY_TEST_TOOL (PROFESSIONAL_SUMMARY_ID, TEST_TOOL_ID)
VALUES
('1', '1'),
('1', '2'),
('1', '3'),
('2', '10'),
('1', '9');



#PROFESSIONAL_SUMMARY_METHODOLOGY TABLE--------------------------------------------------------------------------------
INSERT INTO E_RESUME.PROFESSIONAL_SUMMARY_METHODOLOGY (PROFESSIONAL_SUMMARY_ID, METHODOLOGY_ID)
VALUES
('1', '1'),
('1', '2'),
('1', '3'),
('2', '10'),
('1', '9');



#PROFESSIONAL_SUMMARY_OPERATION_SYSTEM TABLE---------------------------------------------------------------------------
INSERT INTO E_RESUME.PROFESSIONAL_SUMMARY_OPERATION_SYSTEM (PROFESSIONAL_SUMMARY_ID, OS_ID)
VALUES
('1', '1'),
('1', '2'),
('1', '3'),
('2', '10'),
('1', '9');



#PROFESSIONAL_SUMMARY_TECHNOLOGY TABLE---------------------------------------------------------------------------
INSERT INTO E_RESUME.PROFESSIONAL_SUMMARY_TECHNOLOGY (PROFESSIONAL_SUMMARY_ID, TECHNOLOGY_ID)
VALUES
('1', '1'),
('1', '2'),
('1', '3'),
('2', '10'),
('1', '9');




#CERTIFICATION TABLE-------------------------------------------------------------------------------------------------
INSERT INTO E_RESUME.CERTIFICATION (ID, ISSUING_ORGANISATION, CERTIFICATE_NAME, ISSUE_DATE, EXPIRATION_DATE, RESUME_ID)
VALUES
(1, 'Microsoft', 'Microsoft Azure', STR_TO_DATE('01-09-2016', '%d-%m-%Y'), STR_TO_DATE('01-09-2025', '%d-%m-%Y'), 1),
(2, 'Amazon', 'Aws Certified Developer', STR_TO_DATE('01-09-2016', '%d-%m-%Y'), STR_TO_DATE('01-09-2021', '%d-%m-%Y'), 1),
(3, 'Oracle', 'OCP', STR_TO_DATE('01-02-2020', '%d-%m-%Y'), STR_TO_DATE('01-02-2030', '%d-%m-%Y'), 2),
(4, 'Oracle', 'APEX', STR_TO_DATE('01-10-2014', '%d-%m-%Y'), STR_TO_DATE('01-10-2022', '%d-%m-%Y'), 2),
(5, 'The Scrum Alliance', 'Scrum Alliance Certified Scrum Developer', STR_TO_DATE('01-10-2019', '%d-%m-%Y'), STR_TO_DATE('01-10-2023', '%d-%m-%Y'), 2);