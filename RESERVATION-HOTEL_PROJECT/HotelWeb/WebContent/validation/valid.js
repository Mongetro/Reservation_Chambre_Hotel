 /****************************VALIDATION PARCELLE*************************/
		$( document ).ready( function () {
			
			$( "#parcelleForm" ).validate( {
				rules: {
					nom:{
						required:true,
						minlength:3
					},
					prenom:{
						required:true,
						minlength:3
					},
					
				tel:{
						required:true,
						
					},
					codeMARNDR:{
						required:true,
						
					}, 
					commune:{
						required:true,
												
						
					},
					sectionCom: {
						required: true,
						
					},
					localite: {
						required: true,
						minlength: 10
					},
					superficie: {
						required: true,
						
						
					},
					lat1: {
						required: true,
						
					},
					lat2: {
						required: true,
						
					},
					lat3: {
						required: true,
						
					},
					lat4: {
						required: true,
						
					},
					
					long1: {
						required: true,
						
					},
					long2: {
						required: true,
						
					},
					long3: {
						required: true,
						
					},
					long4: {
						required: true,
						
					},
					
					agePlant: {
						required: true,
						
					},
					manguierSP: {
						required: true,
						
					},
					manguierEP: {
						required: true,
						
					},
					productionAn: {
						required: true,
						
					},
				},
				messages: {
					nom: {
						required:"Entrer le nom",					
						minlength:"Le nom doit contenir au moins 3 lettres"
					},
					prenom: {
						required:"Entrer le prenom",					
						minlength:"Le prenom doit contenir au moins 3 lettres"
					},
					
					tel: {
						required:"Entrer le telephone",					
					
					},
					
					codeMARNDR: {
						required:"Entrer le code codeMARNDR",					
						minlength:"L'ID doit contenir au moins 3 lettres"
					},
					commune:{
						required:"Choisir la commune",
						
					},
					sectionCom: {
						required:"Choisir la sectioncommunale",
					
					},
					localite: {
						required:"Entrer la localite",
						minlength: "La localite est trop courte"
					},
					superficie: {
						required:"Entrer la superficie",
						
					},
					lat1: {
						required:"Entrer la latitude1",
                       },
                       lat2: {
   						required:"Entrer la latitude2",
                          },
                          
                          lat3: {
      						required:"Entrer la latitude3",
                             },
                          
                             lat4: {
         						required:"Entrer la latitude4",
                                },
                                
                            	long1: {
            						required:"Entrer la longitude1",
                                   },
                                   long2: {
               						required:"Entrer la longitude2",
                                      },
                                      long2: {
                  						required:"Entrer la longitude2",
                                         },
                                         long3: {
                     						required:"Entrer la longitude3",
                                            },
                                            long4: {
                        						required:"Entrer la longitude4",
                                               },
                                
                                                 
                                               agePlant: {
						required:"Entrer l'age de la plantation",
					
					},
					
				manguierSP: {
						required:"Entrer le nombre de manguier SP"
					
					},
					
					manguierEP: {
						required:"le nombre de manguier EP",
					
					},
					
                    agePlant: {
						required:"Entrer l'age de la plantation",
					
					},
					
					productionAn: {
							required:"Entrer la production annuelle",
						
						},
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
				},
				unhighlight: function (element, errorClass, validClass) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
				}
				
			} );
		} );
		
		




 /****************************VERIFICATION LOTS*************************/

$( document ).ready( function () {
			
			$( "#LotForm" ).validate( {
				rules: {
					 
					noPlaque:{
						required:true,						
					},
					Transpoteur: {
						required: true,
						
					},
					dateTransp: {
						required: true,
						minlength: 5
					},
				
					dateLivraison: {
						required: true,
						
					},
				},
				messages: {
					noPlaque: {
						required:"Entrer le numero de la plaque",
				
					},
					Transpoteur:{
						required:"Entrer le transporteur",
					
					},
					dateTransp: {
						required:"Entrer la date du transport",
						
					},
					dateLivraison: {
						required:"Entrer la date de la livraison",
						
					},
				
					
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.parents( ".col-sm-5" ).addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
				}
			} );
		} );
		



/****************************VERIFICATION ACHAT*************************/
$( document ).ready( function () {
			
			$( "#achatForm" ).validate( {
				rules: {
					 
					achatQT:{
						required:true,						
					},
					achatPT: {
						required: true,
						
					},
					achatIDFour: {
						required: true,
						minlength: 5
					},
				
					achatDate: {
						required: true,
						
					},
				},
				messages: {
					achatProdID: {
						required:"Entrer l'ID du producteur",
				
					},
					achatQT:{
						required:"Entrer la quantite totale",
					
					},
					achatPT: {
						required:"Entrer le prix total",
						
					},
					achatIDFour: {
						required:"Entrer l'id du fournisseur",
						
					},
				
					achatDate: {
						required:"Entrer la date",
						
					},
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.parents( ".col-sm-5" ).addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
				}
			} );
		} );
		




/****************************VERIFICATION FOURNISSEUR*************************/
		$( document ).ready( function () {
			
			$( "#fournForm" ).validate( {
				rules: {
					fournID:{
						required:true,
						minlength: 3
					}, 
					fournNom:{
						required:true,
						
						minlength: 3
						
					},
					fournPrenom: {
						required: true,
						minlength: 2
					},
					fournNif: {
						required: true,
						minlength: 5
					},
					fournAdresse: {
						required: true,
						minlength: 5,
						
					},
					fournEmail: {
						required: true,
						email: true
					},
					fournTel: {
						required: true,
						minlength:8
					},
				
				},
				messages: {
					fournID: {
						required:"Entrer l'ID",
					
						minlength:"L'ID doit contenir au moins 3 lettres"
					},
					fournNom:{
						required:"Entrer le nom",
						minlength:"Le prenom doit contenir au moins 3 lettres"
					},
					fournPrenom: {
						required:"Entrer le prenom",
						minlength:"Le prenom doit contenir au moins 3 lettres"
					},
					fournNif: {
						required:"Entrer le nif",
						minlength:"Le nif doit contenir au moins 10 lettres"
					},
					fournEmail: {
						required:"Entrer l'email",
						email:"Email invalide"
					},
					fournAdresse: {
						required:"Entrer l'adresse",
						minlength:"L'adresse doit contenir au moins 5 lettres"
					},
					fournTel: {
						required:"Entrer le Tel",
						minlength:"Le Tel doit contenir au moins 8 lettres"
					},
					
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.parents( ".col-sm-6" ).addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
				}
			} );
		} );
		
		
		
/****************************VERIFICATION*************************/	
$( document ).ready( function () {
			
			$( "#Verif" ).validate( {
				rules: {
					prodID:{
						required:true,
						
					}, 
					fournID:{
						required:true,
						
					}, 
				
				},
				messages: {
					prodID: {
						required:"Entrer le code du producteur",
					
					},
					fournID: {
						required:"Entrer le code du fournisseur",
					
					},
					
				},
				errorElement: "em",
			
			
			} );
		} );
		
		
		

		
		