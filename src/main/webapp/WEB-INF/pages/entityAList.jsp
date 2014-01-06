<%--
  Created by IntelliJ IDEA.
  User: miroslavkopecky
  Date: 1/6/14
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<div>
    <div>
        <div>
            <!--Sidebar content-->
            Search: <input ng-model="query">
            Sort by:
            <select ng-model="orderProp">
                <option value="name">Alphabetical</option>
                <option value="age">Newest</option>
            </select>

        </div>
        <div>
            <ul>
                <li ng-repeat="entityA in entityAList.list | filter:query | orderBy:orderProp">
                    <a href="/entityAList/{{entityA.name}}">{{entityA.value}}</a>
                    <a href="/entityAList/{{entityA.name}}">{{entityA.name}}</a>
                </li>
            </ul>
        </div>
    </div>
</div>
