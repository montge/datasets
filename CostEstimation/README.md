# Software Cost Estimation Datasets

This repository contains software cost estimation datasets in ARFF (Attribute-Relation File Format) and CSV formats. These datasets are widely used for research and benchmarking in software engineering cost estimation.

Based on data obtained from [CoEST](http://sarec.nd.edu/coest/datasets.html)

## Dataset Overview

The collection includes 16 different datasets from various sources, each containing different attributes and characteristics relevant to software cost estimation:

| Dataset | Records | Attributes | Format | Description |
|---------|---------|------------|--------|-------------|
| albrecht.arff | 24 | 8 | ARFF | Early function point-based cost estimation data |
| china.arff | 499 | 19 | ARFF | Chinese software projects with function points |
| cocomo811.arff | 63 | 17 | ARFF | Classic COCOMO cost estimation data |
| cosmic.arff | 40 | 98 | ARFF | COSMIC function point measurements |
| desharnais.arff | 81 | 12 | ARFF | Desharnais software projects dataset |
| isbsg10.arff | 131 | 67 | ARFF | International Software Benchmarking Standards Group data |
| kemerer.arff | 15 | 8 | ARFF | Kemerer's software cost dataset |
| kitchenham.arff | 145 | 10 | ARFF | Kitchenham software project data |
| maxwell.arff | 62 | 27 | ARFF | Maxwell software development dataset |
| miyazaki94.arff | 48 | 9 | ARFF | Miyazaki software productivity data |
| nasa93.arff | 93 | 24 | ARFF | NASA software projects with COCOMO attributes |
| nasa93-dem.arff | 93 | 29 | ARFF | NASA software projects with additional defect metrics |
| COCOMO-81.csv | 63 | 18 | CSV | COCOMO 1981 dataset in CSV format |
| Desharnais.csv | 81 | 13 | CSV | Desharnais dataset in CSV format |
| UCP_Dataset.csv | 71 | 17 | CSV | Use Case Points estimation dataset |
| finnish.arff | 38 | 9 | ARFF | Estimates in Function points and actuals in person months for large projects |

---

## Dataset Details

### albrecht.arff
**Source**: Albrecht & Gaffney (1983)  
**Attributes**: 8  
**Records**: 24

| Attribute | Type | Description |
|-----------|------|-------------|
| Input | numeric | Number of inputs |
| Output | numeric | Number of outputs |
| Inquiry | numeric | Number of inquiries |
| File | numeric | Number of files |
| FPAdj | numeric | Function points adjustment factor |
| RawFPcounts | numeric | Raw function points count |
| AdjFP | numeric | Adjusted function points |
| Effort | numeric | Development effort |

---

### china.arff
**Source**: Chinese software projects  
**Attributes**: 19  
**Records**: 499

| Attribute | Type | Description |
|-----------|------|-------------|
| ID | numeric | Project identifier |
| AFP | numeric | Application function points |
| Input | numeric | Number of inputs |
| Output | numeric | Number of outputs |
| Enquiry | numeric | Number of enquiries |
| File | numeric | Number of files |
| Interface | numeric | Number of interfaces |
| Added | numeric | Added function points |
| Changed | numeric | Changed function points |
| Deleted | numeric | Deleted function points |
| PDR_AFP | numeric | PDR AFP measure |
| PDR_UFP | numeric | PDR UFP measure |
| NPDR_AFP | numeric | NPDR AFP measure |
| NPDU_UFP | numeric | NPDU UFP measure |
| Resource | numeric | Resource level |
| Dev.Type | numeric | Development type |
| Duration | numeric | Project duration |
| N_effort | numeric | Normalized effort |
| Effort | numeric | Development effort |

---

### cocomo811.arff
**Source**: Boehm's COCOMO 1981  
**Attributes**: 17  
**Records**: 63

| Attribute | Type | Description |
|-----------|------|-------------|
| rely | numeric | Required software reliability |
| data | numeric | Database size |
| cplx | numeric | Product complexity |
| time | numeric | Time constraint |
| stor | numeric | Storage constraint |
| virt | numeric | Virtual machine volatility |
| turn | numeric | Turnaround time |
| acap | numeric | Analyst capability |
| aexp | numeric | Application experience |
| pcap | numeric | Programmer capability |
| vexp | numeric | Virtual machine experience |
| lexp | numeric | Language experience |
| modp | numeric | Modern programming practices |
| tool | numeric | Use of software tools |
| sced | numeric | Schedule constraint |
| loc | numeric | Lines of code |
| actual | numeric | Actual development effort |

---

### cosmic.arff
**Source**: COSMIC function point measurements  
**Attributes**: 98  
**Records**: 40

**Overview**: This dataset contains detailed information about software projects measured using COSMIC function points, with comprehensive coverage of business applications, development environments, and quality metrics. It's particularly valuable for Java business application analysis.

#### Core Project Information

| Attribute | Type | Description | Possible Values |
|-----------|------|-------------|-----------------|
| ID | numeric | Project identifier | Unique numeric IDs |
| Data_Quality | categorical | Data quality rating | A, B |
| UFP | numeric | Unadjusted function points | Numeric values |
| Year | numeric | Development year | 2003-2012 |

#### Business Domain Classification

| Attribute | Type | Description | Possible Values |
|-----------|------|-------------|-----------------|
| IS | categorical | Industry sector | Banking, Government, Insurance, Manufacturing, Medical & Health Care, Professional Services, Communication, Financial, Service Industry, Utilities, Wholesale & Retail, Education, Construction |
| OT | categorical | Organization type | Banking, Government, GovernmentHealth Sciences, Insurance, DefenceAerospace / Automotive, Medical and Health Care, Professional Services, general public (mobile phone end user), Financial Property & Business Services, Food Processing, Electricity Gas Water, Advertising, Wholesale & Retail Trade, Education Institution, Research & development, Transport & Storage, Agriculture Forestry Fishing Hunting, Building Automation, Manufacturing, Professional ServicesEnvironmental Consulting, Telecommunications, Surveillance & Security |
| AG | categorical | Application group | Business Application |
| AT | categorical | Application type | Financial transaction process/accounting, Management or performance reporting, Stock control & order processing, Change Management Tool, Catalogue/register of things or events, Instant Messaging client, Customer billing/relationship management, Logistic tracking, Document management, Printing Documentation Design, Online analysis and reporting, Hospital Information System, Web based fullfilment tool for Advertising, Logistic or supply planning & control, Course management system, Content management system, Workflow support & management, Electronic Data Interchange, Cards and Payments, GUI for Protocol |

#### Development Characteristics

| Attribute | Type | Description | Possible Values |
|-----------|------|-------------|-----------------|
| DT | categorical | Development type | New Development, Enhancement, Re-development |
| DP | categorical | Development platform | MF (Mainframe), PC, Multi (Multi-platform), MR (Mid-range) |
| LT | categorical | Language type | 3GL (Third Generation Language), 4GL (Fourth Generation Language) |
| PPL | categorical | Primary programming language | **Java**, C++, Oracle, ASP.Net, C#, .Net, COBOL, C, ABAP, Script Language, J2EE |

#### Size and Effort Metrics

| Attribute | Type | Description | Possible Values |
|-----------|------|-------------|-----------------|
| CA | categorical | Counting approach | COSMIC |
| FS | numeric | Functional size | Numeric (COSMIC function points) |
| RS | categorical | Resource size category | S (Small), M1 (Medium 1), L (Large), M2 (Medium 2), XXS (Extra Extra Small), XS (Extra Small) |
| N_effort_level1 | numeric | Normalized effort level 1 | Numeric values |
| N_effort | numeric | Normalized effort | Numeric values |
| S_effort | numeric | Scaled effort | Numeric values |
| N_PDR1 | numeric | Normalized PDR 1 | Numeric values |
| N_PDR | numeric | Normalized PDR | Numeric values |
| SDR | numeric | SDR measure | Numeric values |
| PET | numeric | PET measure | Numeric values |
| PIT | numeric | PIT measure | Numeric values |

#### Project Timeline and Phases

| Attribute | Type | Description | Possible Values |
|-----------|------|-------------|-----------------|
| I_Date | categorical | Implementation date | Various dates from 2000-2012 |
| PAS | categorical | Project activities/phases | Planning_Specification_Design_Build_Test_Implement_ProjManagement, Planning_Specification_Design_Build_Test_Implement, Build_Test_Implement, Planning_Specification_Build_Test, Build |
| E_Plan | numeric | Effort - Planning | Numeric (hours) |
| E_Specify | numeric | Effort - Specification | Numeric (hours) |
| E_Design | numeric | Effort - Design | Numeric (hours) |
| E_Build | numeric | Effort - Build | Numeric (hours) |
| E_Test | numeric | Effort - Test | Numeric (hours) |
| E_Implement | numeric | Effort - Implementation | Numeric (hours) |
| E_Unrecorded | numeric | Effort - Unrecorded | Numeric (hours) |

#### Team and Resource Information

| Attribute | Type | Description | Possible Values |
|-----------|------|-------------|-----------------|
| Recording_Method | categorical | Recording method used | Staff hours (recorded), Recorded work on project tasks each day, Recorded total hours each day or week, Recorded hours on each project/day/week, Productive time only (recorded), Other Method |
| Resource_Level | numeric | Resource level | Numeric values |
| TSG | categorical | Team size group | 5-8, 61-70, 21-30, 71-80, 3-4, 1.0, 9-14 |
| MTS | numeric | Maximum team size | Numeric values |
| ATS | numeric | Average team size | Numeric values |
| R_PWE_NPA | categorical | Resource productive work effort | 80%, 97%, 85%, 50%, 100%, 88% |

#### Technology Stack

| Attribute | Type | Description | Possible Values |
|-----------|------|-------------|-----------------|
| CASE_Tool | categorical | CASE tool usage | Yes, No |
| UM | categorical | Use of methodology | Yes, No |
| HMA | categorical | How method acquired | Developed In-house, Combined Developed/Purchased |
| Hardware1 | categorical | Hardware platform | AIXPC, Midrange, PC, Pentium II based processors, PowerPC(G3), HP |
| Language1 | categorical | Programming language details | **Java**, C#.Net, **Java 2 EE**, COBOL, VB6, Oracle eBS, C++, C++Java, Owner script, AppBuilder, COBOLJava, Visual C++ 5.0, ASP.NETC#, RPG3, Ab Initio, ABAP, VB.NET, 3GL, PHP, SLEL |
| OS1 | categorical | Operating system | UNIX/AIX, Windows, Web client, Windows XP, IBM/zOS, Windows Server, Z-OS, TRU64, Windows 2000, Linux, Windows NT, UNIX, AS/400 UNIX, Tandem/NSK |
| IDE | categorical | Development environment | **Eclipse**, EclipseRational ClearCase, Visual Studio 6.0, Oracle eBS, TSO, MS Visual Studio 2005, SAP, Eclipse IDE |
| DT1 | categorical | Development tool | **Eclipse**, No, ladebug, MS Visual Studio 2005, SAP, Xpediter, Eclipse IDE |
| DBS1 | categorical | Database system | **MySQL**, **Oracle**, SQL Server, IDMS-DB, MS SQL Server 2005, UNIX, SQL, DB2, HP, Microsoft SQL Server |
| CS1 | categorical | Communication system | WebSphere, Component, IDMS-DC, WEBLOGIC, No, SQL |
| WS1 | categorical | Web server | **Apache Tomcat 6.0.14**, WebSphere, IIS, **Apache Tomcat 5.5**, MS IIS 6, Apache, Tomcat, BEA Weblogic |
| MS1 | categorical | Messaging system | Tibco BusinessWorks, No, In house, Corporate SMTP Server, BEA Weblogic JMS |

#### Development Practices

| Attribute | Type | Description | Possible Values |
|-----------|------|-------------|-----------------|
| OP1 | categorical | Other platforms/frameworks | In House Framework (written in **Java**), Rules engine: Ilog Jrules, Report Engine, In House Framework (written in **Java**)JSP, LDAP |
| Dev_Methodologies | categorical | Development methodologies | **Agile Development**Personal Software Process (PSP)Unified Process, **Agile Development**Joint Application Development (JAD)Multifunctional Teams, Rapid Application Development (RAD) |
| Dev_Techniques | categorical | Development techniques | Data ModellingPrototyping, Prototyping, Process Modelling |
| JAD_Method | categorical | JAD method usage | Yes |
| PMU | categorical | Project management usage | Yes |

#### Function Point Standards

| Attribute | Type | Description | Possible Values |
|-----------|------|-------------|-----------------|
| FPS | categorical | Function point standard | COSMIC 3.0, COSMIC 2, COSMIC 2.2, COSMIC, COSMIC 3, Cfsu, ISO/IEC FDIS 19761:2002(E), CFFP v2, COSMIC-FFP, COSMIC 2.1 |
| FPSA | categorical | Function point standard applied | COSMIC 3.0, COSMIC 2, COSMIC 2.2, COSMIC, COSMIC 3, Cfsu, ISO/IEC FDIS 19761:2002(E), COSMIC FFP v.2, COSMIC-FFP, COSMIC 2.1 |

#### System Architecture

| Attribute | Type | Description | Possible Values |
|-----------|------|-------------|-----------------|
| Architecture | categorical | System architecture | **Multi-tier with web public interface**, **Client server**, Stand alone, Multi-tier |
| Client_Server? | categorical | Client-server architecture | Yes, No |
| Client_Roles | categorical | Client roles | **Web/HTML browser**, Run a computer-human interface, Data entry & validation, Data retrieval & presentation, Business logic or rule processing, HandHeld Device |
| Server_Roles | categorical | Server roles | Security/authentication, **Database server**, FTP server, **HTML/web server**, Messaging server, Object/component server, Multi-user legacy application, File &/or print server, virtualisation server API |
| TOS | string | Type of system | Free text descriptions |
| CS_Description | string | Client-server description | Free text descriptions |

#### Quality and Tools

| Attribute | Type | Description | Possible Values |
|-----------|------|-------------|-----------------|
| DBMS_Used | categorical | DBMS usage | Yes |
| Upper_CASE_Used | categorical | Upper CASE tool usage | Yes, No |
| Other_CASE_Tools? | categorical | Other CASE tools usage | Yes, No |
| Other_CASE_Tool_Names | categorical | Other CASE tool names | MagicDraw UML, MS VisioArgoUML, Select OMT, OMT++ |

#### Defect Metrics

| Attribute | Type | Description | Possible Values |
|-----------|------|-------------|-----------------|
| MIN_Defects | numeric | Minimum defects | Numeric values |
| MAJ_Defects | numeric | Major defects | Numeric values |
| X_Defects | numeric | Extreme defects | Numeric values |
| TOT_Defects | numeric | Total defects | Numeric values |
| P_Defects | numeric | Post-delivery defects | Numeric values |
| S_Defects | numeric | System defects | Numeric values |
| D_Defects | numeric | Development defects | Numeric values |
| MIN_B_Defects | numeric | Minimum build defects | Numeric values |
| MAJ_B_Defects | numeric | Major build defects | Numeric values |
| X_B_Defects | numeric | Extreme build defects | Numeric values |
| TOT_B_Defects | numeric | Total build defects | Numeric values |
| MIN_T_Defects | numeric | Minimum test defects | Numeric values |
| MAJ_T_Defects | numeric | Major test defects | Numeric values |
| X_T_Defects | numeric | Extreme test defects | Numeric values |
| TOT_T_Defects | numeric | Total test defects | Numeric values |
| MIN_I_Defects | numeric | Minimum implementation defects | Numeric values |
| MAJ_I_Defects | numeric | Major implementation defects | Numeric values |
| X_I_Defects | numeric | Extreme implementation defects | Numeric values |
| TOT_I_Defects | numeric | Total implementation defects | Numeric values |

#### Key Java Business Applications in Dataset:
- **Banking**: Financial transaction processing systems
- **Government**: Document management and workflow systems  
- **Manufacturing**: Change management tools
- **Professional Services**: Business catalog and registration systems
- **Service Industry**: Workflow support and management systems

**Note**: Attributes marked in **bold** indicate particularly relevant values for Java business application development.

---

### desharnais.arff
**Source**: Desharnais (1989)  
**Attributes**: 12  
**Records**: 81

| Attribute | Type | Description |
|-----------|------|-------------|
| Project | numeric | Project identifier |
| TeamExp | numeric | Team experience (years) |
| ManagerExp | numeric | Manager experience (years) |
| YearEnd | numeric | Year of completion |
| Length | numeric | Project length |
| Effort | numeric | Actual effort (person-hours) |
| Transactions | numeric | Number of basic logical transactions |
| Entities | numeric | Number of entities in data model |
| PointsAdjust | numeric | Adjusted function points |
| Envergure | numeric | Scale factor |
| PointsNonAjust | numeric | Unadjusted function points |
| Language | {1,2,3} | Programming language category |

---

### isbsg10.arff
**Source**: International Software Benchmarking Standards Group  
**Attributes**: 67  
**Records**: 131

| Attribute | Type | Description |
|-----------|------|-------------|
| ID | numeric | Project identifier |
| Data_Quality | {A,B} | Data quality assessment |
| UFP | {A,B} | Unadjusted function points quality |
| Year | numeric | Project year |
| IS | categorical | Industry sector |
| OT | categorical | Organization type |
| AG | categorical | Application group |
| AT | categorical | Application type |
| DT | categorical | Development type |
| DP | categorical | Development platform |
| LT | categorical | Language type |
| PPL | categorical | Primary programming language |
| CA | categorical | Counting approach |
| FS | numeric | Functional size |
| RS | categorical | Resource size category |
| N_effort_level1 | numeric | Normalized effort level 1 |
| N_effort | numeric | Normalized effort |
| S_effort | numeric | Scaled effort |
| N_PDR1 | numeric | Normalized PDR 1 |
| N_PDR | numeric | Normalized PDR |
| SDR | numeric | SDR measure |
| PET | numeric | PET measure |
| PIT | numeric | PIT measure |
| I_Date | categorical | Implementation date |
| PAS | categorical | Project activities/phases |
| Recording_Method | categorical | Recording method used |
| Resource_Level | numeric | Resource level |
| MTS | numeric | Maximum team size |
| ATS | numeric | Average team size |
| R_PWE_NPA | categorical | Resource productive work effort |
| P_UWE | numeric | Productive unrecorded work effort |
| CASE_Tool | {Yes,No} | CASE tool usage |
| UM | {Yes} | Use of methodology |
| HMA | categorical | How method acquired |
| Hardware1 | string | Hardware platform |
| Language1 | categorical | Programming language |
| OS1 | categorical | Operating system |
| IDE | categorical | Integrated development environment |
| DT1 | {Yes} | Development tool |
| DBS1 | categorical | Database system |
| CS1 | {No} | Communication system |
| WS1 | categorical | Web server |
| MS1 | categorical | Messaging system |
| OP1 | numeric | Other platforms |
| FPS | categorical | Function point standard |
| FPSA | categorical | Function point standard applied |
| RTA | categorical | Rules and techniques applied |
| BAT | categorical | Business application type |
| SP_CMMI | categorical | CMMI process |
| SP_ISO | categorical | ISO process |
| SP_TICKIT | numeric | TICKIT process |
| MIN_Defects | numeric | Minimum defects |
| MAJ_Defects | numeric | Major defects |
| X_Defects | numeric | Extreme defects |
| TOT_Defects | numeric | Total defects |
| UB_BU | categorical | Usage - Business units |
| UB_L | categorical | Usage - Locations |
| UB_DU | numeric | Usage - Data units |
| UB_CU | categorical | Usage - Concurrent users |
| IMarket | categorical | Internal market |
| T_Platform | categorical | Target platform |
| D_Embedded | numeric | Device embedded |
| SE | numeric | Size estimate |
| SEA | categorical | Size estimate approach |
| SEM | categorical | Size estimate method |
| E_Estimate | numeric | Effort estimate |
| E_Estimate_Method | categorical | Effort estimate method |
| DDE | categorical | Due date estimate |
| DDEM | categorical | Due date estimate method |
| C_Estimate | numeric | Cost estimate |
| CEC | categorical | Cost estimate currency |
| CEM | categorical | Cost estimate method |
| E_Tool | categorical | Estimation tool |
| E_Comments | categorical | Estimation comments |
| EC_Date | numeric | Estimate completion date |
| SR? | {Yes} | Software reuse |
| SR | categorical | Software reuse type |
| R_FPC | numeric | Reused function point count |
| R_FPA | numeric | Reused function point adjusted |
| P_Defects | numeric | Post-delivery defects |
| S_Defects | numeric | System defects |
| D_Defects | numeric | Development defects |
| MIN_B_Defects | numeric | Minimum build defects |
| MAJ_B_Defects | numeric | Major build defects |
| X_B_Defects | numeric | Extreme build defects |
| TOT_B_Defects | numeric | Total build defects |
| MIN_T_Defects | numeric | Minimum test defects |
| MAJ_T_Defects | numeric | Major test defects |
| X_T_Defects | numeric | Extreme test defects |
| TOT_T_Defects | numeric | Total test defects |
| MIN_I_Defects | numeric | Minimum implementation defects |
| MAJ_I_Defects | numeric | Major implementation defects |
| X_I_Defects | numeric | Extreme implementation defects |
| TOT_I_Defects | numeric | Total implementation defects |

---

### kemerer.arff
**Source**: Kemerer (1987)  
**Attributes**: 8  
**Records**: 15

| Attribute | Type | Description |
|-----------|------|-------------|
| ID | numeric | Project identifier |
| Language | numeric | Programming language |
| Hardware | numeric | Hardware platform |
| Duration | numeric | Project duration |
| KSLOC | numeric | Thousands of source lines of code |
| AdjFP | numeric | Adjusted function points |
| RAWFP | numeric | Raw function points |
| EffortMM | numeric | Effort in person-months |

---

### kitchenham.arff
**Source**: Kitchenham et al.  
**Attributes**: 10  
**Records**: 145

| Attribute | Type | Description |
|-----------|------|-------------|
| Project | string | Project name |
| Client.code | {1,2,3,4,5,6} | Client code |
| Project.type | {A,C,D,P,Pr,U} | Project type |
| Actual.start.date | date | Project start date |
| Actual.duration | numeric | Actual duration |
| Actual.effort | numeric | Actual effort |
| Adjusted.function.points | numeric | Adjusted function points |
| Estimated.completion.date | date | Estimated completion date |
| First.estimate | numeric | First effort estimate |
| First.estimate.method | {A,C,CAE,D,EO,W} | Estimation method used |

---

### maxwell.arff
**Source**: Maxwell software dataset  
**Attributes**: 27  
**Records**: 62

| Attribute | Type | Description |
|-----------|------|-------------|
| Syear | numeric | System year |
| App | numeric | Application type |
| Har | numeric | Hardware |
| Dba | numeric | Database |
| Ifc | numeric | Interface |
| Source | numeric | Source |
| Telonuse | numeric | Telon usage |
| Nlan | numeric | Number of languages |
| T01 | numeric | Project factor T01 |
| T02 | numeric | Project factor T02 |
| T03 | numeric | Project factor T03 |
| T04 | numeric | Project factor T04 |
| T05 | numeric | Project factor T05 |
| T06 | numeric | Project factor T06 |
| T07 | numeric | Project factor T07 |
| T08 | numeric | Project factor T08 |
| T09 | numeric | Project factor T09 |
| T10 | numeric | Project factor T10 |
| T11 | numeric | Project factor T11 |
| T12 | numeric | Project factor T12 |
| T13 | numeric | Project factor T13 |
| T14 | numeric | Project factor T14 |
| T15 | numeric | Project factor T15 |
| Duration | numeric | Project duration |
| Size | numeric | System size |
| Time | numeric | Development time |
| Effort | numeric | Development effort |

---

### miyazaki94.arff
**Source**: Miyazaki (1994)  
**Attributes**: 9  
**Records**: 48

| Attribute | Type | Description |
|-----------|------|-------------|
| ID | categorical | Project identifier (A1-T1) |
| KLOC | numeric | Thousands of lines of code |
| SCRN | numeric | Number of screens |
| FORM | numeric | Number of forms |
| FILE | numeric | Number of files |
| ESCRN | numeric | Enhanced screens |
| EFORM | numeric | Enhanced forms |
| EFILE | numeric | Enhanced files |
| MM | numeric | Person-months effort |

---

### nasa93.arff
**Source**: NASA software projects (1993)  
**Attributes**: 24  
**Records**: 93

| Attribute | Type | Description |
|-----------|------|-------------|
| recordnumber | real | Unique project ID |
| projectname | categorical | Project name |
| cat2 | categorical | Application category |
| forg | {f,g} | Flight or ground system |
| center | {1,2,3,4,5,6} | NASA center |
| year | real | Development year |
| mode | categorical | Development mode |
| rely | categorical | Required reliability |
| data | categorical | Database size |
| cplx | categorical | Product complexity |
| time | categorical | Time constraint |
| stor | categorical | Storage constraint |
| virt | categorical | Virtual machine volatility |
| turn | categorical | Turnaround time |
| acap | categorical | Analyst capability |
| aexp | categorical | Applications experience |
| pcap | categorical | Programmer capability |
| vexp | categorical | Virtual machine experience |
| lexp | categorical | Language experience |
| modp | categorical | Modern programming practices |
| tool | categorical | Use of software tools |
| sced | categorical | Schedule constraint |
| equivphyskloc | real | Equivalent physical KLOC |
| act_effort | real | Actual development effort |

---

### nasa93-dem.arff
**Source**: NASA software projects with defect data  
**Attributes**: 29  
**Records**: 93

| Attribute | Type | Description |
|-----------|------|-------------|
| id | numeric | Project identifier |
| prec | {h} | Precedentedness |
| flex | {h} | Development flexibility |
| resl | {h} | Architecture/risk resolution |
| team | {vh} | Team cohesion |
| pmat | {l,n,h} | Process maturity |
| rely | {l,n,h,vh} | Required reliability |
| data | {l,n,h,vh} | Database size |
| cplx | {l,n,h,vh,xh} | Product complexity |
| ruse | {n} | Required reusability |
| docu | {n} | Documentation match to life-cycle needs |
| time | {n,h,vh,xh} | Time constraint |
| stor | {n,h,vh,xh} | Storage constraint |
| pvol | {l,n,h} | Platform volatility |
| acap | {n,h,vh} | Analyst capability |
| pcap | {n,h,vh} | Programmer capability |
| pcon | {n} | Personnel continuity |
| apex | {l,n,h,vh} | Applications experience |
| plex | {vl,l,n,h} | Platform experience |
| ltex | {vl,l,n,h} | Language and tool experience |
| tool | {n,h} | Use of software tools |
| site | {n} | Multisite development |
| sced | {n,l,h} | Schedule constraint |
| kloc | numeric | Thousands of lines of code |
| effort | numeric | Development effort (person-months) |
| defects | numeric | Total defects |
| months | numeric | Development length (months) |

---

### COCOMO-81.csv
**Source**: Boehm's COCOMO 1981 in CSV format  
**Attributes**: 18  
**Records**: 63

| Attribute | Type | Description |
|-----------|------|-------------|
| num | numeric | Project identifier |
| dev_mode | categorical | Development mode (organic, semidetached, embedded) |
| rely | numeric | Required software reliability |
| data | numeric | Database size |
| cplx | numeric | Product complexity |
| time | numeric | Time constraint |
| stor | numeric | Storage constraint |
| virt | numeric | Virtual machine volatility |
| turn | numeric | Turnaround time |
| acap | numeric | Analyst capability |
| aexp | numeric | Application experience |
| pcap | numeric | Programmer capability |
| vexp | numeric | Virtual machine experience |
| lexp | numeric | Language experience |
| modp | numeric | Modern programming practices |
| tool | numeric | Use of software tools |
| sced | numeric | Schedule constraint |
| loc | numeric | Lines of code (KLOC) |
| actual | numeric | Actual development effort (person-months) |

---

### Desharnais.csv
**Source**: Desharnais (1988) in CSV format  
**Attributes**: 13  
**Records**: 81

| Attribute | Type | Description |
|-----------|------|-------------|
| id | numeric | Project identifier |
| Project | numeric | Project number |
| TeamExp | numeric | Team experience (years) |
| ManagerExp | numeric | Manager experience (years) |
| YearEnd | numeric | Year of completion |
| Length | numeric | Project length (months) |
| Effort | numeric | Actual effort (person-hours) |
| Transactions | numeric | Number of basic logical transactions |
| Entities | numeric | Number of entities in data model |
| PointsNonAdjust | numeric | Unadjusted function points |
| Adjustment | numeric | Adjustment factor |
| PointsAjust | numeric | Adjusted function points |
| Language | categorical | Programming language category (1,2,3) |

---

### UCP_Dataset.csv
**Source**: Use Case Points estimation research  
**Attributes**: 17  
**Records**: 71

| Attribute | Type | Description |
|-----------|------|-------------|
| Project_No | numeric | Project number |
| Simple Actors | numeric | Number of simple actors |
| Average Actors | numeric | Number of average actors |
| Complex Actors | numeric | Number of complex actors |
| UAW | numeric | Unadjusted Actor Weight |
| Simple UC | numeric | Number of simple use cases |
| Average UC | numeric | Number of average use cases |
| Complex UC | numeric | Number of complex use cases |
| UUCW | numeric | Unadjusted Use Case Weight |
| TCF | numeric | Technical Complexity Factor |
| ECF | numeric | Environmental Complexity Factor |
| Real_P20 | numeric | Real UCP (Person*20) |
| Real_Effort_Person_Hours | numeric | Real effort in person hours |
| Sector | categorical | Business sector |
| Language | categorical | Programming language |
| Methodology | categorical | Development methodology |
| ApplicationType | categorical | Type of application |
| DataDonator | categorical | Data contributor |

**Summary**: Use Case Points estimation with business sector and technology information. **Contains Java business applications**.

---

### finnish.arff
**Source**: Sigweni & Shepperd (2015)  
**Attributes**: 9  
**Records**: 38

| Attribute | Type | Description |
|-----------|------|-------------|
| ID | numeric | Project identifier |
| dev.eff.hrs | numeric | Development effort hours |
| hw | numeric | Hardware factor |
| at | numeric | Application type |
| FP | numeric | Function points |
| co | numeric | Company factor |
| prod | numeric | Productivity |
| lnsize | numeric | Natural log of size |
| lneff | numeric | Natural log of effort |

**Summary**: Estimates in Function points and actuals in person months for large projects.

---

## Usage Notes

- Datasets are available in ARFF, CSV, and text formats
- Missing values are indicated by `?` in some datasets
- Effort is typically measured in person-months or person-hours
- Size metrics include lines of code (LOC/KLOC) and function points
- COCOMO datasets use standard effort multiplier scales (vl, l, n, h, vh, xh)

## Applications

These datasets are commonly used for:
- Software cost estimation model development
- Benchmarking estimation techniques
- Machine learning research in software engineering
- Empirical software engineering studies
- Validation of cost estimation tools and methods

## References

### Primary References

**Albrecht Dataset:**
- Albrecht, A.J. & Gaffney, J. (1983). Software function, source lines of code, and development effort prediction. *IEEE Transactions on Software Engineering*, 9, 639-648.

**COCOMO Datasets (cocomo811, nasa93, nasa93-dem):**
- Boehm, B. (1981). *Software Engineering Economics*. Prentice Hall.
- Boehm, B., Horowitz, E., Madachy, R., Reifer, D., Clark, B.K., Steece, B., Brown, A.W., Chulani, S., & Abts, C. (2000). *Software Cost Estimation with Cocomo II*. Prentice Hall. ISBN: 0130266922.

**Desharnais Dataset:**
- Desharnais, J.M. (1989). Analyse statistique de la productivitie des projets informatique a partie de la technique des point des fonction. University of Montreal, Masters Thesis.
- Shepperd, M.J. & Schofield, C. (1997). Estimating software project effort using analogies. *IEEE Transactions on Software Engineering*, 23, 736-743.

**NASA93 Additional Studies:**
- Menzies, T., Port, D., Chen, Z., Hihn, J., & Stukes, S. (2005). Validation Methods for Calibrating Software Effort Models. *Proceedings ICSE 2005*. Available: http://menzies.us/pdf/04coconut.pdf
- Chen, Z., Menzies, T., Port, D., & Boehm, B. (2005). Feature Subset Selection Can Improve Software Cost Estimation Accuracy. *Proceedings PROMISE Workshop 2005*. Available: http://www.etechstyle.com/chen/papers/05fsscocomo.pdf

**COCOMO Validation Studies:**
- Chulani, S., Boehm, B., & Steece, B. (1999). Bayesian Analysis of Empirical Software Engineering Cost Models. *IEEE Transaction on Software Engineering*, 25(4), July/August.
- Srinivasan, K. & Fisher, D. (1995). Machine Learning Approaches to Estimating Software Development Effort. *IEEE Trans. Soft. Eng.*, February, pages 126-137.

**General Software Cost Estimation:**
- Shepperd, M. & Schofield, C. (1997). Estimating software project effort using analogies. *IEEE Transactions on Software Engineering*, 23(12), November. Available: http://www.utdallas.edu/~rbanker/SE_XII.pdf

**Additional Studies Using These Datasets:**
- Li, Y.F., Xie, M., & Goh, T.N. (2009). A Study of Project Selection and Feature Weighting for Analogy Based Software Cost Estimation. *Journal of Systems and Software*, 82(2), 241-252.
- Li, Y.F., Xie, M., & Goh, T.N. (2009). A Study on the Non-linear Adjustment for Analogy Based Software Cost Estimation. *Empirical Software Engineering*, 14(6), 603-643.

### Data Contributors

**Albrecht Dataset:**
- Donor: Yanfu Li (liyanfu@nus.edu.sg), October 14, 2009

**Desharnais Dataset:**
- Donor: Martin Shepperd (Martin.Shepperd@brunel.ac.uk)

**COCOMO Datasets:**
- Donor: Tim Menzies (tim@barmag.net), December 2, 2004
- Original transcription by Srinivasan and Fisher from Boehm's 1981 text

### Data Sources

**PROMISE Repository:**
- Multiple datasets (albrecht, desharnais) are from the PROMISE Software Engineering Repository, made publicly available to encourage repeatable, verifiable, refutable, and improvable predictive models of software engineering.
- Repository information: http://promise.site.uottawa.ca/SERepository

**ISBSG Data:**
- Cosmic and ISBSG datasets are derived from the International Software Benchmarking Standards Group.
- Full ISBSG data available from: https://www.isbsg.org/

**CoEST Collection:**
- This collection is based on data obtained from [CoEST](http://sarec.nd.edu/coest/datasets.html)

**COCOMO-81.csv:**
- Boehm, B. (1981). *Software Engineering Economics*. Prentice-Hall, Inc.

**Desharnais.csv:**
- Desharnais, J.M. (1988). Analyse Statistique de la Productivite des Projets de Developpement en Informatique a Partir de la Technique des Points de Fonction (Statistical Analysis on the Productivity of Data Processing with Development Projects using the Function Point Technique). MSc, Université du Québec à Montréal.

**UCP_Dataset.csv:**
- Silhavy, R., Silhavy, P., & Prokopova, Z. (2017). Analysis and selection of a regression model for the Use Case Points method using a stepwise approach. *The Journal of Systems and Software*, 125(C), 1-14.

**finnish.arff:**
- Sigweni, B. & Shepperd, M. (2015). Using Blind Analysis for Software Engineering Experiments. *Proceedings of the 19th International Conference on Evaluation and Assessment in Software Engineering*, pp. 1-6.

**China Dataset:**
- Yun, F.H. (2010). China: Effort Estimation Dataset. Zenodo.

**Kitchenham Dataset:**
- Kitchenham, B., Pfleeger, S.L., McColl, B., & Eagan, S. (2002). An empirical study of maintenance and development estimation accuracy. *Journal of Systems and Software*, 64(1), 57-77.

**Maxwell Dataset:**
- Maxwell, K.D. (2002). *Applied Statistics for Software Managers*. Prentice-Hall.

**Miyazaki Dataset:**
- Miyazaki, Y., Terakado, M., Ozaki, K., & Nozaki, H. (1994). Robust regression for developing software estimation models. *Journal of Systems and Software*, 27(1), 3-16.

**NASA93 Dataset:**
- Menzies, T., Port, D., Chen, Z., Hihn, J., & Stukes, S. (2005). Validation Methods for Calibrating Software Effort Models. *27th International Conference on Software Engineering*, pp. 587-595.

For detailed information about specific datasets, measurement procedures, and data collection methods, please refer to the individual ARFF file headers and the original publications listed above.