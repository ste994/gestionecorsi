$(document).ready(function(){
	$('#userForm').bootstrapValidator({
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
		},
		fields : {
			nomeCorsista : {
				container : '#infoNome',
				validators : {
					notEmpty : {
						message : 'Il nome non pu&ograve; essere vuoto'   
					},
					regexp : {
						regexp : /^[a-zA-Z ,.'-]{2,30}$/,
						message : 'Da 2 a 30 caratteri' 
					}
				}
			},
			cognomeCorsista : {
				container : '#infoCognome',
				validators : {
					notEmpty : {
						message : 'Il cognome non pu&ograve; essere vuoto'   
					},
					regexp : {
						regexp : /^[a-zA-Z ,.'-]{2,30}$/,
						message : 'Da 2 a 30 caratteri' 
					}
				}
			},
			indirizzo : {
				container : '#infoIndirizzo',
				validators : {
					notEmpty : {
						message : 'L\'indirizzo non pu&ograve; essere vuoto'   
					},
					regexp : {
						regexp : /^[a-zA-Z ,.'-]+[0-9]{1,3}$/,
						message : 'Inserire via | viale | piazza e numero civico' 
					}
				}
			},
			cap : {
				container : '#infoCap',
				validators : {
					notEmpty : {
						message : 'Il cap non pu&ograve; essere vuoto'   
					},
					regexp : {
						regexp : /^[0-9]{5}$/,
						message : 'Inserire 5 cifre per il cap' 
					}
				}
			},
			nascita : {
				container : '#infoNascita',
				validators : {
					notEmpty : {
						message : 'La nascita non pu&ograve; essere vuota'   
					},
					date : {
						format : 'DD/MM/YYYY',
						message : 'La data deve essere nel formato dd/mm/yyyy' 
					}
				}
			},
			username : {
				container : '#infoUsername',
				validators : {
					notEmpty : {
						message : 'Lo username non pu&ograve; essere vuoto'   
					},
					regexp : {
						regexp : /^[a-zA-Z0-9]{4,10}$/,
						message : 'Inserire lettere e numeri come username' 
					}
				}
			},
			password : {
				container : '#infoPassword',
				validators : {
					notEmpty : {
						message : 'Lo password non pu&ograve; essere vuota'   
					},
					regexp : {
						regexp : /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,30}$/,
						message : 'Inserire almeno 1 char maisc, 1 char minusc e 1 carattere speciale' 
					}
				}
			},
			email : {
				container : '#infoEmail',
				validators : {
					notEmpty : {
						message : 'La mail non pu&ograve; essere vuota'   
					},
					regexp : {
						regexp : /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-\+]+\.[a-zA-Z]{2,}$/,
						message : 'Inserire una mail valida' 
					}
				}
			}			
		}
	});
});

	
	
	
	
	
