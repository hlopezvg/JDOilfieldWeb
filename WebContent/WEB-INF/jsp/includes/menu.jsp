<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="tabsJ" class="ocultar_print">
	<ul>
		<core:choose>
			<core:when test="${sessionScope.m==null}">
				<li id="current"><a href="home.htm"><span>Home</span> </a></li>
			</core:when>
			<core:otherwise>
				<li><a href="home.htm"> <span>Home</span></a></li>
			</core:otherwise>
		</core:choose>
		<core:forEach items="${menuSort}" var="c">
			<core:if test="${menu[c.component.id].consult==true}">
				<core:choose>
					<core:when test="${menu[c.component.id].component.id==sessionScope.m}">
						<li id="current">
							<a title="${menu[c.component.id].component.description}" href="${menu[c.component.id].component.page}?m=${menu[c.component.id].component.id}"> 
								<span>${menu[c.component.id].component.name}</span>
							</a>
						</li>
					</core:when>
					<core:otherwise>
						<li>
							<a title="${menu[c.component.id].component.description}" href="${menu[c.component.id].component.page}?m=${menu[c.component.id].component.id}">
								<span>${menu[c.component.id].component.name}</span>
							</a>
						</li>
					</core:otherwise>
				</core:choose>
			</core:if>
		</core:forEach>
	</ul>
</div>