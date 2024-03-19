// var empService = {infoReq, saveReq, listReq}

var empService = (function(){

// 날짜 포맷
function dateFormat(dt){
	let	date = new Date(dt);
	let result = date.getFullYear() + '-' + ((date.getMonth()+1) <= 9 ? "0" + (date.getMonth()+1) : (date.getMonth()+1))
				+ '-' + (date.getDate() <= 9 ? "0" + date.getDate() : date.getDate());
	return result;				
}
			
// 상세조회 요청
function infoReq(empId){
	fetch(`/ajax/emp/${empId}`)
		.then(res => res.json())
		.then(res => infoRes(res))
}
			
// 상세조회 응답
function infoRes(res){
	// input tag에 표시
	frm.email.value = res.email;
	frm.lastName.value = res.lastName;
	frm.jobId.value = res.jobId;
	frm.hireDate.value = res.hireDate;
}
			
// 리스트 요청
async function listReq(p){ // async는 동기식에서만
	const param = "?page=" + p
	/* fetch("/ajax/empList" + param)
		.then(res => res.json())
		.then(res => listRes(res))	 */	
//비동기식
//	axios.get("/ajax/empList" + param)
//		 .then(res => listRes(res.data))
		 
// 동기식
	const res = await axios.get("/ajax/empList" + param);
	listRes(res.data)
}
	
// 리스트 응답
function listRes(res){
	emplist.innerHTML = '';
	let i = 0;
	// 목록 출력
	for(obj of res.data){
		emplist.innerHTML += makeTr(++i, obj);
	}
	// 페이징 처리
	nav.innerHTML = makePage(res.paging)
}

function makePage(paging){
	console.log(paging)
	let tag = `<nav aria-label="...">
				<ul class="pagination">`
	if(paging.startPage > 1){
		tag += `<li class="page-item">
				<a class="page-link" href="javascript:gopage(${paging.startPage - 1})">Previous</a></li>`
	}
	// 페이지 번호
	for(i = paging.startPage; i <= paging.endPage; i++){
		tag += `<li class="page-item">
				<a class="page-link" href="javascript:gopage(${i})">${i}</a></li>`
	}
	// 다음 버튼
	if(paging.endPage < paging.lastPage){
		tag += `<li class="page-item">
			<a class="page-link" href="javascript:gopage(${paging.endPage + 1})">Next</a></li>`
	}
	
	tag += `</ul></nav>`
	
	return tag;
}
			
			
function makeTr(i, obj){
	let bonusBtn = '<button>신청</button>'
	if(obj.salary > 10000){
		bonusBtn = '<button>신청불가</button>'
	}
	let newTag = `
		<tr>
			<td>${i}</td>
			<td onclick="infoReq(${obj.employeeId})">${obj.employeeId}</td>
			<td>${obj.firstName} ${obj.lastName}</td>
			<td>${dateFormat(obj.hireDate)}</td>
			<td>${obj.salary}</td>
			<td>${bonusBtn}</td>
			<td><button type="button" onclick="move(${obj.employeeId})">조회</button></td>
		</tr>`
		
		return newTag;
}
			
// 등록 요청
function saveReq(){
// 1. queryString
//	const lastName=frm.lastName.value;
//	const email=frm.email.value;
//	const hireDate=frm.hireDate.value;
//	const jobId=frm.jobId.value;
//	let param = `lastName=${lastName}&email=${email}&hireDate=${hireDate}&jobId=${jobId}`;
				
//	fetch("/ajax/emp", {
//		method : "post" ,
//		body : param,
//		headers: {
//			'Content-Type': 'application/x-www-form-urlencoded',
//		},
//	})

// 2. FormData 
//	let param = new FormData(document.frm);
//	fetch("/ajax/emp",{
//		method : "post",
//		body : param
//	})

// 3. JsonString  ( payload )
const lastName = frm.lastName.value;
const email = frm.email.value;
const jobId = frm.jobId.value;
const hireDate = frm.hireDate.value;
let param = {lastName, email, jobId, hireDate}

/* fetch("/ajax/emp",{
	method : "post",
	headers: {
  		"Content-Type": "application/json",
		},
	body : JSON.stringify(param)
	})
	.then(res => res.json())
	.then(res => saveRes(res)) */

axios.post("/ajax/emp", param)
	 .then(res => saveRes(res.data))
}
			
//등록 응답
function saveRes(res){
	listReq(1)
	frm.email.value = "";
	frm.lastName.value = "";
	frm.jobId.value = "";
	frm.hireDate.value = "";
}
			
return {infoReq, saveReq, listReq}
})();