AI Based Attribute Evaluation Models For Auction Based eCommerce Markets
==============================================================================

Artificial Intelligence:
..* Linear Regression
..* Support Vector Machine

Technolgy:
⋅⋅*Java
⋅⋅*Weka
⋅⋅*MySQL
⋅⋅*PHP
⋅⋅*HTML
⋅⋅*CSS

In this app we look at sales data provided by eBay, the most widely used auction based eCommerce
platform, and attempt to generate attribute based pricing models for individual items using algorithms
provided with the Weka suite. Sales data was collected from the eBay API for all completed sales of 4
popular items within a 90 day window. Using the linear regression and support vector machine classes
provided by Weka we generated models which we used to predict the dollar value of a given attribute for a
set of items. Our models were then tested against an outside test set and evaluated for mean squared error
or predicted prices. Linear Regression, while still very inaccurate, outperformed SVM regression using
our current dataset. We hope to expand the possibilities of this project in the future with the collection of
larger datasets and the generation of more accurate models.

