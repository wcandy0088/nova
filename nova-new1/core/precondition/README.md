Preconditions
==========

### Overview
Design Custom Precondition Policies that can be applied to Nflows
Precondition Policies are written as simple Java POJO along with custom Annotations that allow the system to transform policies to/from the User Interface.
The Annotations are the same as those used for the **"field-policy"** module Standardization and Validation policies

Below is the mapping of the User Interface Object and its respective to Domain Model

### Requirements
1. Policy Constructor rules

    The PreconditionPolicy objects must follow *one* of the following rules

      1. Have a no arg constructor
      2. or Have a constructor with parameters each annotated with **@PolicyPropertyRef** (See examples below)

2. Policies must implement the Precondition interface and must be annotated with **@PreconditionPolicy**

### Quick Start
   
   1. Create a class that implements `com.onescorpin.policy.precondition.Precondition`
   2. Add the `@PreconditionPolicy` annotation to the class
   3. Annotate any field inputs with `@PolicyProperty` and any Constructor arguments with `@PolicyPropertyRef`


### Annotations
#### @PolicyProperty - Field Annotation
**Purpose:** Annotate any Parameter that is needed to be captured the User Interface in order to create the Precondition

| Attribute              | Required  | Default Value | Description      | 
| -----------------      | --------- | -------------    |------------|
| name                   | Y         |                  | Unique Name for the User Inerface and Domain to match. <br/> **NOTE** This will also become the User Interface Display Name, (**displayName attribute**) if one is not specified |
| displayName            | N         | name value above | The display name on the UI |
| value                  | N         |                  | default value on the UI |
| placeholder            | N         |                  | Html Placeholder attribute |
| type                   | N         |  string          | Render Types. Available Options (number, string, select, regex, date, chips,nflowChips, currentNflow) |
| selectableValues       | N         |                  | If type is **select** this is the Array of Strings that will be in the list<br/> Optionally use the property below for a label/value render |
| labelValues            | N         |                  | If type is **select** this is the Array of Label/Values that will be in the list |
| required               | N         | false            | Indicate if input is required by user in the UI |


#### @PolicyPropertyRef - Parameter Annotation
**Purpose:** Annotate any Constructor Parameter that references a given 
**@PolicyProperty**

| Attribute     | Required |  Description |
| ----------    | -------- | ----------   |
| name          | Y        | This name should match the @PolicyProperty name |


#### @PreconditionPolicy  - Class Annotation
**Purpose:** Annotate the Class to inform the system and the User Interface that this is a PreconditionPolicy

| Attribute     | Required |  Description |
| ----------    | -------- | ----------   |
| name          | Y        | This name of the Precondition.  This will be displayed on the User Interface |
| shortDescription   | N        | Short Description of the Precondition. This will be displayed on the User Interface  |
| description   | N        |  A Longer Description of the Precondition.  |


How To
=======

1. Create a new Java Class that implements the **Precondition** class
2. Add the the **@PreconditionPolicy** annotation to your class
3. Implement the **getPreconditionObligations()** that builds up the correct **Metric** objects defined in the **"sla-api"** module and creates the correct Condition/Obligation.

```java
@PreconditionPolicy(name = PreconditionPolicyConstants.NFLOW_EXECUTED_SINCE_NFLOWS_NAME, description = "Policy will trigger the nflow when all of the supplied nflows have successfully finished")
public class NflowExecutedSinceNflows implements Precondition {

    @PolicyProperty(name = "Since Nflow", type = PolicyProperty.PROPERTY_TYPE.currentNflow)
    private String sinceCategoryAndNflowName;

    @PolicyProperty(name = "Dependent Nflows", required = true, type = PolicyProperty.PROPERTY_TYPE.nflowChips, placeholder = "Start typing a nflow",
                    hint = "Select nflow(s) that this nflow is dependent upon")
    private String categoryAndNflows;

    private List<String> categoryAndNflowList;

    public NflowExecutedSinceNflows(@PolicyPropertyRef(name = "Since Nflow") String sinceCategoryAndNflowName, @PolicyPropertyRef(name = "Dependent Nflows") String categoryAndNflows) {
        this.sinceCategoryAndNflowName = sinceCategoryAndNflowName;
        this.categoryAndNflows = categoryAndNflows;
        categoryAndNflowList = Arrays.asList(StringUtils.split(categoryAndNflows, ","));
    }
    
    @Override
        public Set<PreconditionGroup> getPreconditionObligations() {
            Set<Metric> metrics = new HashSet<>();
            for (String categoryAndNflow : categoryAndNflowList) {
                NflowExecutedSinceNflow metric = new NflowExecutedSinceNflow(sinceCategoryAndNflowName, categoryAndNflow);
                metrics.add(metric);
            }
            Set<PreconditionGroup> preconditionGroups = new HashSet<>();
            preconditionGroups.add(new DefaultPreconditionGroup(metrics, ObligationGroup.Condition.REQUIRED.name()));
            return preconditionGroups;
        }
```
