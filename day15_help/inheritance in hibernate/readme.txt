There are three inheritance mapping strategies defined in the hibernate:

1.Table Per Hierarchy
2. Table Per Concrete class
3. Table Per Subclass

1. Table Per Hierarchy
In table per hierarchy mapping, single table is required to map the whole hierarchy, an extra column (known as discriminator column) is added to identify the class. But nullable values are stored in the table .
Use @Inheritance(strategy=InheritanceType.SINGLE_TABLE) & @DiscriminatorColumn in parent class and @DiscriminatorValue annotations in child class.

In case of table per hierarchy, only one table is required to map the inheritance hierarchy. Here, an extra column (also known as discriminator column) is created in the table to identify the subtype class.


2. Table Per Concrete class
In case of table per concrete class, tables are created as per class. But duplicate column is added in subclass tables.
 Use  @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) annotation in the parent class and @AttributeOverrides annotation in the subclasses.



@AttributeOverrides defines that parent class attributes will be overriden in this class. In table structure, parent class table columns will be added in the subclass table.

3.
Table Per Subclass
In this strategy, tables are created as per class but related by foreign key. So there are no duplicate columns.

We need to specify @Inheritance(strategy=InheritanceType.JOINED) in the parent class and @PrimaryKeyJoinColumn annotation in the subclasses.
