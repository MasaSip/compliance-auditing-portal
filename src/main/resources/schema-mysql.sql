CREATE TABLE IF NOT EXISTS users(
       user_id INT PRIMARY KEY AUTO_INCREMENT,

       username NVARCHAR(20),
       password NVARCHAR(60),
       email NVARCHAR(50),
       first_name NVARCHAR(30),
       last_name NVARCHAR(30),
       gender NVARCHAR(15),
       designation NVARCHAR(20),
       title NVARCHAR(20)
);


CREATE TABLE IF NOT EXISTS user_groups(
       usergroup_id INT PRIMARY KEY AUTO_INCREMENT,
       user_id INT, FOREIGN KEY(user_id) REFERENCES users(user_id),
       usergroup NVARCHAR(30),
       priority NVARCHAR(30),
       sign_location NVARCHAR(30)
);

CREATE TABLE IF NOT EXISTS eventlog (
       event_id INT PRIMARY KEY,
       username NVARCHAR(30),
       cdate DATE,
       user_id INT, FOREIGN KEY(user_id) REFERENCES users(user_id)
);


CREATE TABLE IF NOT EXISTS compliance_type (
       comptype_id INT PRIMARY KEY,
       comptype NVARCHAR(40)
);

CREATE TABLE IF NOT EXISTS report(
      report_id INT PRIMARY KEY AUTO_INCREMENT,
      reporttype NVARCHAR(40),
      user_id INT, FOREIGN KEY(user_id) REFERENCES users(user_id),
      substation NVARCHAR(20),
      rdate DATE,
      start_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
      end_time TIMESTAMP NULL,


       senior_engineer_email NVARCHAR(50),
       manager_email NVARCHAR(50),
       general_manager_email NVARCHAR(50),
       ceo_email NVARCHAR(50)
);

CREATE TABLE IF NOT EXISTS facility (
  id INT PRIMARY KEY AUTO_INCREMENT,
  report_id INT, FOREIGN KEY(report_id) REFERENCES report(report_id),
  name NVARCHAR(200),
  description TEXT

);

CREATE TABLE IF NOT EXISTS compliance (
       comp_id INT PRIMARY KEY AUTO_INCREMENT,
       check_id NVARCHAR(30),
       yes_id BOOLEAN NOT NULL DEFAULT FALSE,
       comment NVARCHAR(255),
       report_id INT, FOREIGN KEY(report_id) REFERENCES report(report_id),
       media_files BLOB,



       facility_id INT, FOREIGN KEY(facility_id) REFERENCES facility(id),
       compliance_date TIMESTAMP NULL,
       name NVARCHAR(255)
);


CREATE TABLE IF NOT EXISTS licensee (
       licensee_id INT PRIMARY KEY,
       holder_name NVARCHAR(40),
       location NVARCHAR(40)
);


CREATE TABLE IF NOT EXISTS substation_type (
       subtype_id INT PRIMARY KEY,
       subtype NVARCHAR(40)
);


CREATE TABLE IF NOT EXISTS substation (
       substation_id INT PRIMARY KEY,
       licensee_id INT, FOREIGN KEY (licensee_id) REFERENCES licensee (licensee_id),
       substation_name NVARCHAR(30),
       subtype_id INT, FOREIGN KEY(subtype_id) REFERENCES substation_type(subtype_id)
);


CREATE TABLE IF NOT EXISTS checklist (
       checklist_id INT PRIMARY KEY,
       substation_id INT, FOREIGN KEY (substation_id) REFERENCES substation (substation_id),
       questions NVARCHAR(100)
);

