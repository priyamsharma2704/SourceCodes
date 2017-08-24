const assert = require('chai').assert;
const app = require('../app').packageInstaller;

describe('PackageInstallerTDD', function() {
	describe('Valid test cases', function() {
		it('test with one dependancy no cycle',function(){
			let input = ["Leetmeme: Cyberportal"];
			let result = app(input);
			assert.equal(result,"Cyberportal,Leetmeme");
		});	

		it('test with two dependancies no cycle',function(){
			let input = ["Leetmeme: Cyberportal","Cyberportal: Ice"];
			let result = app(input);
			assert.equal(result,"Ice,Cyberportal,Leetmeme");
		});

		it('test with given valid case',function(){
			let input = ["KittenService: ",
					"Leetmeme: Cyberportal",
					"Cyberportal: Ice",
					"CamelCaser: KittenService",
					"Fraudstream: Leetmeme",
					"Ice: "];
			let result = app(input);
			assert.equal(result,"KittenService,Ice,Cyberportal,Leetmeme,CamelCaser,Fraudstream");
		});
	});

	describe('Invlaid test cases', function() {
		it('test with two dependancies cycle',function(){
			let input = ["Leetmeme: Cyberportal","Cyberportal: Leetmeme"];
			let result = app(input);
			assert.equal(result,"Install Order contains cyclic dependancy");
		});

		it('test with given invalid case',function(){
			let input = ["KittenService: ",
					"Leetmeme: Cyberportal",
					"Cyberportal: Ice",
					"CamelCaser: KittenService",
					"Fraudstream: ",
					"Ice: Leetmeme"];
			let result = app(input);
			assert.equal(result,"Install Order contains cyclic dependancy");
		});

		it('test with empty string array',function(){
			let input = [": "];
			let result = app(input);
			assert.equal(result,"Install Order contains cyclic dependancy");
		});
		
	});
	
});







