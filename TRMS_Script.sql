--drop table trms.employee;
create table trms.employee(
employee_empId serial not null,
employee_firstName varchar(50) not null,
employee_lastName varchar(50) not null,
employee_emailId varchar(50) not null,
employee_contactNo varchar(50) not null,
employee_city varchar(50) not null,
employee_state varchar(50) not null,
employee_empTitle varchar(50) not null,
employee_hireDate varchar(50) not null,
employee_reportsTo varchar(50) not null,
employee_username varchar(50) not null,
employee_password varchar(50) not null,
constraint empId_pk primary key (employee_empId) 
);

--drop table trms.reimrequest;
create table trms.ReimRequest(
ReimRequest_requestId serial not null,
employee_empId serial not null,
ReimRequest_category varchar(50) not null,
ReimRequest_courseDate varchar(10) not null,
ReimRequest_submissionDate varchar(10) not null,
ReimRequest_amount varchar(10) not null,
ReimRequest_description varchar(80),
ReimRequest_grading varchar(30) not null,
constraint reqId_pk primary key (ReimRequest_requestId),
constraint empId_fk foreign key (employee_empId) references trms.employee (employee_empId) ON DELETE cascade on update cascade
);

--drop table trms.Approval;
create table trms.Approval(
Approval_ApprovalId serial not null,
ReimRequest_requestId serial not null,
Approval_BenCoApproval varchar(25),
Approval_DirSupApproval varchar(25),
Approval_HODApproval varchar(25),
constraint approval_pk primary key (Approval_ApprovalId),
constraint reqId_fk foreign key (ReimRequest_requestId) references trms.ReimRequest (ReimRequest_requestId) ON DELETE cascade on update cascade
);

--drop table trms.attachments;
create table trms.attachments(
attachment_attachmentId serial not null,
Approval_ApprovalId serial not null,
attachment_content varchar (50),
attachment_filepath varchar(50),
constraint attachId_pk primary key (attachment_attachmentId),
constraint approvalId_fk foreign key (Approval_ApprovalId) references trms.Approval (Approval_ApprovalId) ON DELETE cascade on update cascade
);

--------------------------------------------------------------------------------------------------------------------
--ALTER TABLE trms.ReimRequest ADD CONSTRAINT fk_empId
--    FOREIGN KEY (employee_empId) REFERENCES trms.employee (employee_empId) ON DELETE cascade on update cascade;

  -- ALTER TABLE trms.attachments ADD CONSTRAINT fk_requestId
   -- FOREIGN KEY (ReimRequest_requestId) REFERENCES trms.reimRequest (ReimRequest_requestId) ON DELETE cascade on update cascade;
   

   --alter table Hand add constraint fk_Hand_player_id
--foreign key (player_id) references Player (player_id) on delete cascade on update cascade;
--create index i_fk_Hand_player_id on Hand (player_id);
    